package com.javabro.spring_boot_learning.kafkalisteners;

import com.javabro.spring_boot_learning.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MyKafkaListener {

    Logger logger = LoggerFactory.getLogger(MyKafkaListener.class);

    @KafkaListener(topics = {"employee-topic"}, groupId = "employee-group")
    public void consumeKafkaEmployeeTopic(Employee employee) {
        logger.debug("received message in kafka-topic");
        System.out.println("message posted to the kafka employee topic is ===========> "+employee.getFirstName());
    }
}
