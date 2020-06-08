package com.jin.config.mq.topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

/**
 * @author shuai.jin
 * @date 2020/6/6 17:44
 */
@Configuration
public class ActiveMQTopicConfig {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    @Qualifier(value = "activeMQTopicListener")
    private MessageListener messageListener;

    @Autowired
    @Qualifier(value = "activeMQTopic2Listener")
    private MessageListener messageListener2;

    /**
     * 创建一个主题bean，主题的名称为：springboot-activemq-topic-test1
     * @return
     */
    @Bean(value = "topic1")
    public ActiveMQTopic activeMQTopic() {
        ActiveMQTopic activeMQTopic = new ActiveMQTopic(TopicEnum.FIRST_TOPIC.getTopicName());
        return activeMQTopic;
    }


    @Bean(value = "topicContainer")
    public MessageListenerContainer messageListenerContainer() {
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(connectionFactory);
        defaultMessageListenerContainer.setMessageListener(messageListener);
        defaultMessageListenerContainer.setDestination(activeMQTopic());
        return defaultMessageListenerContainer;
    }

    @Bean(value = "topic2Container")
    public MessageListenerContainer messageListenerContainer2() {
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(connectionFactory);
        defaultMessageListenerContainer.setMessageListener(messageListener2);
        defaultMessageListenerContainer.setDestination(activeMQTopic());
        return defaultMessageListenerContainer;
    }
}
