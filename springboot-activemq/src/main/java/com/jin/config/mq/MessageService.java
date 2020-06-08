package com.jin.config.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import javax.jms.Topic;

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

    @Autowired
    @Qualifier(value = "topic1")
    private Topic topic;

    public void sendQueueMessage(String messageContent) {
        jmsTemplate.send(queue, session -> session.createTextMessage(messageContent));
    }

    public void sendTopicMessage(String messageContent) {
        jmsTemplate.send(topic,session -> session.createTextMessage(messageContent));
    }

}
