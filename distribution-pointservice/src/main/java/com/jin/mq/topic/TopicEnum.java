package com.jin.mq.topic;

import lombok.Getter;

/**
 * @author      shuai.jin
 * @date        2020-6-6 17:40
 */
@Getter
public enum TopicEnum {


    /**
     * 事件主体
     */
    EVENT_TOPIC("eventTopic", "distribution-transaction-topic"),

    USER_ID_TOPIC("userIdTopic", "distribution-transaction-user-id-topic");

    private String topicDecl;

    private String topicName;


    TopicEnum(String topicDecl, String topicName) {
        this.topicDecl = topicDecl;
        this.topicName = topicName;
    }
}
