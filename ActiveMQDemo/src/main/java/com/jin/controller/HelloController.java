package com.jin.controller;

import com.jin.entity.AO.UserAO;
import com.jin.mq.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.JMSException;

/**
 * @Author shuai.jin
 * @Description TODO
 * @Date 2020/4/8 14:49
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/hello")
    public String sayHello(@RequestBody UserAO userAO) {
        log.info("sayHello请求入参为：--->{}", userAO);
        try {
            messageProducer.sendMsg(userAO.toString());
        } catch (JMSException e) {
            log.error("发送消息失败：--->{}", e.toString());
            return "Fail";
        }
        return "Success";
    }
}
