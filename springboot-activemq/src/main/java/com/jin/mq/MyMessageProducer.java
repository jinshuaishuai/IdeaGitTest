package com.jin.mq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.jms.MessageProducer;

/**
 * @author shuai.jin
 * @description TODO
 * @Date 2020/5/23 11:51
 */
public class MyMessageProducer {

    private static final String username = ActiveMQConnection.DEFAULT_USER;

    private static final String password = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) throws JMSException {
        /*
            创建连接工厂
         */
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username, password, url);

        //从连接工厂里创建一条资源的连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //根据连接创建一条会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        //由会话创建一个队列
        Queue queue = session.createQueue("activemq-queue-test2");
        //创建一个消息的生产对象，消息发送的目的队列是"activemq-queue-test1"
        MessageProducer messageProducer = session.createProducer(queue);
        //创建一条普通文本类型的消息
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("goods");
        //消息由消息发送方发送
        messageProducer.send(textMessage);

        session.commit();
        //关闭会话
        session.close();
        //关闭连接资源
        connection.close();

    }
}
