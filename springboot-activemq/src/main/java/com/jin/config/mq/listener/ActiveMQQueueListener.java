package com.jin.config.mq.listener;

import lombok.SneakyThrows;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/25 13:33
 */
public class ActiveMQQueueListener implements MessageListener {

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        System.out.println("消息消费成功：" + ((TextMessage) message).getText());
    }
}
