package com.jin.scheduler;

import com.jin.entity.domain.EventDO;
import com.jin.entity.query.EventQuery;
import com.jin.mapper.EventMapper;
import com.jin.mq.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author shuai.jin
 * @date 2020/6/21 18:26
 */
//下面那个Component注解是要加的
@Component
public class EventScheduler {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private MessageService messageService;

    //每三秒执行一次
    @Scheduled(cron = "*/3 * * * * ?")
    public void scanTeventTable() {
        EventQuery eventQuery = new EventQuery();
        eventQuery.setProcess("NEW");
        List<EventDO> list = eventMapper.getEventListByParams(eventQuery);
        if(list != null && list.size() > 0) {
            list.forEach(eventDo -> {
                //向消息队列的特定主体中发送一条消息
                messageService.sendTopicMessage(eventDo.getContent());
                EventDO target = new EventDO();
                target.setId(eventDo.getId());
                target.setProcess("PUBLISHED");
                eventMapper.updateEvent(target);
            });
        }
    }
}
