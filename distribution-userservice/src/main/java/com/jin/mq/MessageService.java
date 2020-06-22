package com.jin.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

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
    @Qualifier(value = "eventTopic")
    private Topic topic;

    public void sendTopicMessage(String messageContent) {
        jmsTemplate.send(topic,session -> session.createTextMessage(messageContent));
    }

}
