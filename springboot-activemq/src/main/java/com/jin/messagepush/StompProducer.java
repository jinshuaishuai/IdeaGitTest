package com.jin.messagepush;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.transport.stomp.StompConnection;

/**
 * @author shuai.jin
 * @date 2020/6/9 8:54
 */
public class StompProducer {
    public static void main(String[] args) throws Exception {
        StompConnection stompConnection = new StompConnection();
        stompConnection.open("localhost",61613);

        stompConnection.connect(ActiveMQConnection.DEFAULT_USER,ActiveMQConnection.DEFAULT_PASSWORD);

        String message = "<a href='http://www.baidu.com'>葡萄美酒夜光杯</a>";
        stompConnection.send("topic/shopping- discount",message);
        stompConnection.disconnect();
        stompConnection.close();

    }
}
