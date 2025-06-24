package com.SentinelStream.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "sentinel-topic", groupId = "sentinel-group")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}
