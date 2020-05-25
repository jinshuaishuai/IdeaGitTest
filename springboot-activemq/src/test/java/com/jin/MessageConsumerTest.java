package com.jin;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author shuai.jin
 * @Description TODO
 * @Date 2020/4/8 13:58
 */
public class MessageConsumerTest {
    private static final  String url="tcp://47.92.4.79:8008"; //61616是mq的默认端口
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
        //6.创建消费者，去目的地取消息
        MessageConsumer consumer = session.createConsumer(destination);
        //7.消费者监听消费信息，创建一个监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;

                try {
                    String text = textMessage.getText();
                    System.out.println("text的内容为：---：" + text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }

//                System.out.println("接受消息 = " + textMessage);
            }
        });
        //8.关闭连接
        //connection.close();
    }
}

