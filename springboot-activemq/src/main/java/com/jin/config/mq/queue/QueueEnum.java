package com.jin.config.mq.queue;

import lombok.Getter;

/**
 * 队列名称枚举类
 */
@Getter
public enum QueueEnum {

    firstQueue("firstQueue", "springboot-activemq-queue-test1"),
    secondQueue("secondQueue", "springboot-activemq-queue-test2");

    private String queueDecl;       //队列名称描述

    private String queueName;       //队列名称

    QueueEnum(String queueDecl, String queueName) {
        this.queueName = queueName;
        this.queueDecl = queueDecl;
    }

}
