package com.jin.scheduler;

import com.google.gson.Gson;
import com.jin.entity.bo.PointBO;
import com.jin.entity.domain.EventDO;
import com.jin.entity.domain.PointDO;
import com.jin.entity.query.EventQuery;
import com.jin.mapper.EventMapper;
import com.jin.mapper.UserPointMapper;
import com.jin.mq.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/21 19:32
 */
@Slf4j
@Component
public class EventScheduler {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private UserPointMapper userPointMapper;

    @Autowired
    private MessageService messageService;

    @Scheduled(cron = "*/3 * * * * ?")
    @Transactional(rollbackFor = Exception.class)
    public void eventProcess() {
        //轮询事件表中process字段为PUBLISHED的所有记录
        EventQuery eventQuery = new EventQuery();
        eventQuery.setProcess("PUBLISHED");

        Gson gson = new Gson();
        List<EventDO> list = eventMapper.getEventListByParams(eventQuery);
        if(list != null && list.size() > 0) {
            list.forEach(eventDo -> {
                String content = eventDo.getContent();
                PointBO pointBo = gson.fromJson(content, PointBO.class);
                PointDO pointDo = new PointDO();
                pointDo.setUserId(pointBo.getUserId());
                pointDo.setPoint(pointBo.getPoint());
                /*
                TODO 模拟出现一个错误，验证是否会出现事务不一致的情况，肯定会！！！
                解决方案：捕获该异常，在异常类中，向消息中推送
                 */
                try {
//                    System.out.println(1/0);
                    //添加用户的积分记录
                    userPointMapper.addPoint(pointDo);
                } catch (Exception e) {
                    log.error("新增用户积分时出现错误：------>{}", e.toString());
                    //当新增积分失败时，此时向消息队列中发送一条消息，消息内容为新建用户积分错误的用户id
                    //此时DB2中的事件表的process状态就要改为EXCEPTION,content的值为用户的id，开启定时任务，扫描事件表中记录为EXCEPTION
                    //所有的数据，每扫描到一条，向消息队列中推送一条数据
                    EventDO target = new EventDO();
                    target.setId(eventDo.getId());
                    target.setProcess("EXCEPTION");
                    eventMapper.updateEvent(target);
                    return;
                }

                //当积分记录添加成功后,更改事件表的process值为PROCESSED
                EventDO target = new EventDO();
                target.setId(eventDo.getId());
                target.setProcess("PROCESSED");
                eventMapper.updateEvent(target);
            });
        }
    }

    @Scheduled(cron = "*/3 * * * * ?")
    public void exceptionProcess() {
        //轮询事件表中process字段为EXCEPTION的所有记录
        EventQuery eventQuery = new EventQuery();
        eventQuery.setProcess("EXCEPTION");

        List<EventDO> list = eventMapper.getEventListByParams(eventQuery);
        if(list != null && list.size() > 0) {
            list.forEach(eventDo -> {
                String content = eventDo.getContent();
                //每发现一条，向队列中推送一条消息，消息内容：{"userId":x,"point":y}
                messageService.sendTopicMessage(content);
                //更改process的状态
                EventDO target = new EventDO();
                target.setId(eventDo.getId());
                target.setProcess("OCCUR_EXCEPTION");
                eventMapper.updateEvent(target);
            });
        }
    }
}
