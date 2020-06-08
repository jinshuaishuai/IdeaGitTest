package com.jin.controller;

import com.jin.config.mq.MessageService;
import com.jin.entity.AO.UserAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author shuai.jin
 * @Description TODO
 * @Date 2020/4/8 14:49
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/hello")
    public String sayHello(@RequestBody UserAO userAO) {
        log.info("sayHello请求入参为：--->{}", userAO);
        messageService.sendQueueMessage(userAO.toString());
        messageService.sendTopicMessage("发送的是主题消息");
        return "Success";
    }
}
