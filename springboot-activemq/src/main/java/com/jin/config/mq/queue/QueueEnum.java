package com.jin.config.mq.queue;

import lombok.Getter;

/**
 * @author  shuai.jin
 * @date    2020-6-6 17:39
 */
@Getter
public enum QueueEnum {

    /**
     * 队列的名称1
     */
    FIRST_QUEUE("firstQueue", "springboot-activemq-queue-test1"),

    SECOND_QUEUE("secondQueue", "springboot-activemq-queue-test2");

    /**
     * 队列名称描述
     */
    private String queueDecl;

    /**
     * 队列名称
     */
    private String queueName;

    QueueEnum(String queueDecl, String queueName) {
        this.queueName = queueName;
        this.queueDecl = queueDecl;
    }

}
