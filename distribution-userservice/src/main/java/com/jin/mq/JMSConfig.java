package com.jin.mq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.SimpleMessageConverter;

import javax.jms.ConnectionFactory;

/**
 * <p>
 *     消息队列配置类
 * </p>
 * @author  shuai.jin
 * @date    2020/5/25 10:39
 */
@Configuration
public class JMSConfig {

    /**
     * JMS连接工厂
     * @param activeMQConnectionFactory
     * @return
     */
    @Bean(value = "connectionFactory")
    public ConnectionFactory connectionFactory(@Qualifier(value = "activemqConnectionFactory") ActiveMQConnectionFactory activeMQConnectionFactory) {
        ConnectionFactory connectionFactory = activeMQConnectionFactory;
        return connectionFactory;
    }


    /**
     * activemq连接工厂类
     * @return
     */
    @Bean(value = "activemqConnectionFactory")
    public ActiveMQConnectionFactory activeConnnectionFactory() {
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        return activeMQConnectionFactory;
    }

    @Bean
    public CachingConnectionFactory cachingConnectionFactory(@Qualifier(value = "connectionFactory") ConnectionFactory connectionFactory) {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        //自动注入带缓存的连接工厂，不用每次都创建一个新的连接工厂，使用的线程池的功能
        cachingConnectionFactory.setTargetConnectionFactory(connectionFactory);
        return cachingConnectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(@Autowired CachingConnectionFactory cachingConnectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(cachingConnectionFactory);
        SimpleMessageConverter messageConverter = new SimpleMessageConverter();
        jmsTemplate.setMessageConverter(messageConverter);
        return jmsTemplate;
    }
}
