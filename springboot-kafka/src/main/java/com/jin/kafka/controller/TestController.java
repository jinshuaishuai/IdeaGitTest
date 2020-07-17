package com.jin.kafka.controller;

import com.jin.kafka.mq.MessageSend;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuai.jin
 * @date 2020/7/9 14:02
 */
@RestController
@Slf4j
@RequestMapping(value = "/kafka")
public class TestController {

    @Autowired
    private MessageSend messageSend;

    @GetMapping("/test")
    public String sendMessage(@RequestParam String message) {
        messageSend.sendMessage("test1", message);
        return "success";
    }
}
