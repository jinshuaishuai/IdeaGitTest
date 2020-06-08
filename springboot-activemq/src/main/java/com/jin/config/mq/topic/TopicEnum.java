package com.jin.config.mq.topic;

import lombok.Getter;

/**
 * @author      shuai.jin
 * @date        2020-6-6 17:40
 */
@Getter
public enum TopicEnum {

    /**
     * 第一个主题名称
     */
    FIRST_TOPIC("firstTopic","springboot-activemq-topic-test1"),

    SECOND_TOPIC("secondTopic", "springboot-activemq-topic-test2");

    private String topicDecl;

    private String topicName;


    TopicEnum(String topicDecl, String topicName) {
        this.topicDecl = topicDecl;
        this.topicName = topicName;
    }
}
