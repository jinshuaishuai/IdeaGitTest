package com.jin;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageProducerTest {
    private static final  String url="tcp://localhost:61616"; //61616是mq的默认端口
    private static final  String queue="test1";//队列名字

    public static void main(String[] args) throws JMSException {
        //1.创建ConnectionFactory（连接工厂）
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        //2.创建connect(连接)
        Connection connection = connectionFactory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建会话,俩参数
        Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.目的地，消息发送的地方
        Destination destination = session.createQueue(queue);
        //6.创建生产者，向目的地发送消息
        MessageProducer producer = session.createProducer(destination);
        //循环的发送消息
        for(int i=0;i<100;i++){
            //7.创建消息
            TextMessage textMessage = session.createTextMessage("test"+i);
            //8.发布消息
            producer.send(textMessage);
            System.out.println("发送消息 = " + textMessage);
        }
        //9.关闭连接
        connection.close();
    }
}
