package com.jin;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.Test;

import javax.jms.*;

/**
 * @author shuai.jin
 * @Date 2020/5/23 12:38
 */
public class MyMessageConsumerTest {

    private static final String username = ActiveMQConnection.DEFAULT_USER;

    private static final String password = ActiveMQConnection.DEFAULT_PASSWORD;

    private static final String brokerUrl = ActiveMQConnection.DEFAULT_BROKER_URL;

    @Test
    public void testMessageConsum() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(username, password, brokerUrl);

        //根据连接工厂拿到一个具体的activemq资源连接
        Connection connection = connectionFactory.createConnection();
        connection.start();     //开启连接
        //从资源连接中获取会话
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("activemq-queue-test2");
        MessageConsumer messageConsumer = session.createConsumer(queue);

        //服务进行到这一步，会一直进行监听，当队列activemq-queue-test2一有消息，就会消费。但是消费后，不确定，该消息从队列中消除
        messageConsumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    String text = textMessage.getText();
                    System.out.println("从消息代理中的activemq-queue-test2队列中获取的文本类型消息为：" + text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
