package com.jin.kafka.mq;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author shuai.jin
 * @date 2020/9/30 15:25
 */
@Component
public class kafkaConsumer {

    @KafkaListener(topics = {"test1"})
    public void listen(ConsumerRecord<?,?> consumerRecord) {
        System.out.println(consumerRecord.offset());
        System.out.println(consumerRecord.topic());
        System.out.println(consumerRecord.value());
    }
}
