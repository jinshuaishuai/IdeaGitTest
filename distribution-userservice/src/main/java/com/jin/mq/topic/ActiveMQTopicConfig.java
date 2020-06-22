package com.jin.mq.topic;

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
    @Qualifier(value = "userIdTopicListener")
    private MessageListener userIdTopicListener;

    //要保存事件消息的消息主题
    @Bean(value = "eventTopic")
    public ActiveMQTopic eventMQTopic() {
        ActiveMQTopic activeMQTopic = new ActiveMQTopic(TopicEnum.EVENT_TOPIC.getTopicName());
        return activeMQTopic;
    }

    //监控特定消息的主题
    @Bean(value = "userIdTopic")
    public ActiveMQTopic userIdTopic() {
        return new ActiveMQTopic(TopicEnum.USER_ID_TOPIC.getTopicName());
    }

    @Bean(value = "topicContainer")
    public MessageListenerContainer messageListenerContainer() {
        DefaultMessageListenerContainer defaultMessageListenerContainer = new DefaultMessageListenerContainer();
        defaultMessageListenerContainer.setConnectionFactory(connectionFactory);
        defaultMessageListenerContainer.setMessageListener(userIdTopicListener);
        defaultMessageListenerContainer.setDestination(userIdTopic());
        return defaultMessageListenerContainer;
    }
}
