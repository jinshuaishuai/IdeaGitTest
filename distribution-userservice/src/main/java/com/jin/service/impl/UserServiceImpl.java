package com.jin.service.impl;

import com.google.gson.Gson;
import com.jin.entity.ao.UserAO;
import com.jin.entity.bo.PointBO;
import com.jin.entity.domain.EventDO;
import com.jin.entity.domain.UserDO;
import com.jin.exception.BusinessException;
import com.jin.exception.UserAddException;
import com.jin.mapper.EventMapper;
import com.jin.mapper.UserMapper;
import com.jin.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;

/**
 * @author shuai.jin
 * @date 2020/6/20 7:58
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EventMapper eventMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addUser(UserAO userAo) throws NoSuchAlgorithmException {
        /*
         * 分布式事务实现方案之本地事件表加消息队列的方式
         * 步骤一：向用户表中新增一条用户记录，同时向事件表中新增一条process为NEW的记录，content的内容为积分json格式的字符串
         * 成功后，提交事务
         *
         * 步骤二：在用户服务中开启一个定时任务，定时扫描积分表中process为NEW的所有记录，每发现一个，就向消息队列的特定的主题
         * 上发送一条消息，消息的内容为content字段的值，发送成功后，更改事件表中的process状态为PUBLISHED。
         *
         * 步骤三：积分服务监控消息队里中的某个特定的主题，获得消息后，向DB2中的事件表中新增一条记录，process为PUBLISHED，type为
         * 新建积分，content的值为消息的内容，提交事务。
         *
         * 步骤四：积分服务开启一个定时任务，定时扫描事件表中process为PUBLISHED的所有记录，每发现一个，就将时间表中的content字段
         * 取出，将json格式的积分数据转为积分对象，向积分表中新增一条积分记录，成功后，将事件表中的process字段改为PROCESSED，
         * 提交事务。
         *
         *
         * 出现的问题：
         *  在新增积分记录时，可能存在着保存积分记录失败的情况，此时，用户记录已经新增，事务已经提交，这个时候，用户记录和积分记录新增原子性被打破。
         * 解决方案：
         *  在前四步的基础上，增加以下两个步骤：
         *  步骤五，捕获新增积分可能出现的异常，在catch块中处理事件表的process字段的值为EXCEPTION。然后结束执行后面的语句
         *  步骤六，在积分服务中新开启一个定时任务，扫描事件表中process字段为EXCEPTION的所有记录，每扫描到一个，将该记录的content内容发送到特定的消息队列的主题中
         *  步骤七，回到用户服务，用户服务监控特定的消息主题，拿到content的内容后，将其转化为含有用户id的bean对象，删除用户表中对应的记录。
         *
         *
         */

        log.info("接口入参为：------>{}", userAo);

        UserDO userDo = new UserDO();
        BeanUtils.copyProperties(userAo, userDo);
        userMapper.addUser(userDo);

        if(1 > 0) {
//            throw new NoSuchAlgorithmException("没有该算法");
            throw new UserAddException("用户新增失败");
        }

        PointBO pointBo = new PointBO();
        pointBo.setUserId(userDo.getId());
        BigDecimal point = new BigDecimal(20);
        pointBo.setPoint(point);
        Gson gson = new Gson();
        EventDO eventDo = new EventDO();
        eventDo.setType("addUser");
        eventDo.setProcess("NEW");
        eventDo.setContent(gson.toJson(pointBo));

        eventMapper.addEvent(eventDo);
    }

    @Override
    public UserDO getUserById(int userId) {
        return userMapper.getUserById(userId);
    }

}
