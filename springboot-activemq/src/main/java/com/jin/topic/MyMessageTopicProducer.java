package com.jin.topic;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/25 8:57
 */
public class MyMessageTopicProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PWD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PWD, URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();     //开启连接

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("my-activemq-topic-test1");

        MessageProducer producer = session.createProducer(topic);
        TextMessage textMessage = session.createTextMessage("我的第一条主题消息1");
        producer.send(textMessage);

        session.close();
        connection.close();

    }
}
