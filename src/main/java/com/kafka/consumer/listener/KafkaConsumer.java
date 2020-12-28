package com.kafka.consumer.listener;

import com.kafka.consumer.model.Person;
import com.kafka.consumer.solrservice.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LogManager.getLogger(KafkaConsumer.class);

    @Autowired
    PersonService personService;

    @KafkaListener(topics = "Kafka_Example", groupId = "group_id")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }


    // @KafkaListener(topics = "QPERSON", group = "group_json", containerFactory = "userKafkaListenerFactory")
    @KafkaListener(topics = "QPERSON", groupId = "group_json", containerFactory = "userKafkaListenerFactory")
    public void consumeJson(Person person) {
        personService.savePersonsData(person);
    }
}
