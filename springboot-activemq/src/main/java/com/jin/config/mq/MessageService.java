package com.jin.config.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * @author shuai.jin
 * @date 2020/5/25 13:38
 */
@Service
public class MessageService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier(value = "queue1")
    private Queue queue;

    public void sendMessage(String messageContent) {
        jmsTemplate.send(queue, session -> session.createTextMessage(messageContent));
    }

}
