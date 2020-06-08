package com.jin.config.mq.listener;

import lombok.SneakyThrows;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @author shuai.jin
 * @date 2020/6/6 17:48
 */
public class ActiveMQTopicListener implements MessageListener {

    @SneakyThrows
    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        System.out.println("消费的主题内容为：" + ((TextMessage) message).getText());
    }
}
