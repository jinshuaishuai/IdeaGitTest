package com.jin.config.mq.queue;

import com.jin.config.mq.listener.ActiveMQQueueListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.MessageListener;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/25 11:57
 */
@Configuration
public class ActiveMQQueueListenerConfig {

    @Bean(value = "activeMQQueueListener")
    public MessageListener messageListener() {
        return new ActiveMQQueueListener();
    }
}
