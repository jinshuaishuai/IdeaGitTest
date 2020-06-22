package com.jin.mq.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.MessageListener;

/**
 * @author shuai.jin
 * @date 2020/6/22 5:22
 */
@Configuration
public class UserIdTopicActiveMqListenerConfig {

    @Bean(value = "userIdTopicListener")
    public MessageListener activeMqMessageListener() {
        return new UserIdTopicActiveMqListener();
    }
}
