package com.jin.mq.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.MessageListener;

/**
 * @author shuai.jin
 * @date 2020/6/6 17:57
 */
@Configuration
public class ActiveMQTopicListenerConfig {

    @Bean(value = "eventTopicListener")
    public MessageListener messageListener() {
        return new ActiveMQTopicListener();
    }

}
