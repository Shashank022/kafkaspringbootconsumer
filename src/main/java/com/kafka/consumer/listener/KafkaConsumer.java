package com.kafka.consumer.listener;

import com.kafka.consumer.model.Person;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "Kafka_Example", group = "group_id")

    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


   // @KafkaListener(topics = "QPERSON", group = "group_json", containerFactory = "userKafkaListenerFactory")
    @KafkaListener(
            topicPartitions = @TopicPartition(topic = "QPERSON",
                    partitionOffsets = {
                            @PartitionOffset(partition = "0", initialOffset = "0"),
                            @PartitionOffset(partition = "3", initialOffset = "0")}),
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Person person) {
        System.out.println("Consumed JSON Message: " + person);
    }
}
