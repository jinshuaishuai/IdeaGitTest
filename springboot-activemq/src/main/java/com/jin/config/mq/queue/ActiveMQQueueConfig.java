package com.jin.config.mq.queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;
import javax.jms.Queue;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/25 11:40
 */
@Configuration
public class ActiveMQQueueConfig {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    @Qualifier(value = "activeMQQueueListener")
    private MessageListener messageListener;

    /**
     * 创建队列一
     * @return
     */
    @Bean(value = "queue1")
    public Queue queue1() {
        ActiveMQQueue queue = new ActiveMQQueue(QueueEnum.firstQueue.getQueueName());
        return queue;
    }

    /**
     * 创建队列二
     * @return
     */
    @Bean(value = "queue2")
    public Queue queue2() {
        ActiveMQQueue queue = new ActiveMQQueue("springboot-activemq-queue-test2");
        return queue;
    }

    @Bean
    public MessageListenerContainer messageListenerContaine() {
        DefaultMessageListenerContainer messageListenerContainer = new DefaultMessageListenerContainer();
        messageListenerContainer.setConnectionFactory(connectionFactory);
        messageListenerContainer.setDestination(queue1());
        messageListenerContainer.setMessageListener(messageListener);
        return messageListenerContainer;
    }

}
