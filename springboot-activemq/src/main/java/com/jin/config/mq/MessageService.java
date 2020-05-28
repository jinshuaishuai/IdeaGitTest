package com.jin.config.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/25 13:38
 */
@Service
public class MessageService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier(value = "queue1")
    private Queue queue;

    public void sendMessage(String messageContent) {
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(messageContent);

                return textMessage;
            }
        });
    }

}
