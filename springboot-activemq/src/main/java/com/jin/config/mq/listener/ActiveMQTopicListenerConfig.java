package com.jin.config.mq.listener;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.MessageListener;

/**
 * @author shuai.jin
 * @date 2020/6/6 17:57
 */
@Configuration
public class ActiveMQTopicListenerConfig {

    @Bean(value = "activeMQTopicListener")
    public MessageListener messageListener() {
        return new ActiveMQTopicListener();
    }

    @Bean(value = "activeMQTopic2Listener")
    public MessageListener messageListener2() {
        return new ActiveMQTopic2Listener();
    }

    public static void main(String[] args) {
        System.out.println("七月份薪资总额" + (5946 + 678 + 17563 + 10700 - 1900 - 1900 + 10700 - 2000));
    }
}
