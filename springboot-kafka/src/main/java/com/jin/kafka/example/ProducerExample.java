package com.jin.kafka.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shuai.jin
 * @date 2020/7/9 10:53
 */
public class ProducerExample {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("bootstrap.servers","localhost:9092");
        map.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        map.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        map.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        map.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        map.put("zk.connect","localhost:2181");

        String topic = "test-topic";

        Producer producer = new KafkaProducer(map);
        producer.send(new ProducerRecord<String, String>(topic, "java message 1"));

        producer.send(new ProducerRecord<String, String>(topic, "java message 2"));

        producer.send(new ProducerRecord(topic, "java message 3"));

        producer.close();
    }
}
