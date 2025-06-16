package com.lazrak;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Component
class MessageConsumer {

    @KafkaListener(topics = "first.messages", groupId = "sentinelshield-group")
    public void listen(ConsumerRecord<String, String> record) {
        System.out.println("Received from Kafka: " + record.value());
    }
}