package com.jin.topic;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/25 9:03
 */
public class MyMessageTopicConsumer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;

    private static final String PWD = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) throws Exception {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USERNAME, PWD, URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("my-activemq-topic-test1");

        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MessageListener() {
            @SneakyThrows
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                String text = textMessage.getText();
                System.out.println("线程 " + Thread.currentThread().getName() + " 消费者从主题中获取到的消息为：" + text);
            }
        });

        MessageConsumer consumer2 = session.createConsumer(topic);
        consumer2.setMessageListener(new MessageListener() {
            @SneakyThrows
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                String text = textMessage.getText();
                System.out.println("线程 " + Thread.currentThread().getName() + " 消费者从主题中获取到的消息为：" + text);
            }
        });



    }

}
