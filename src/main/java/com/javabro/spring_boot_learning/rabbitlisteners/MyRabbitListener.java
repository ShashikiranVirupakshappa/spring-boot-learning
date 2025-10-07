package com.javabro.spring_boot_learning.rabbitlisteners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(queues = "sampleQueue")
    public void consume(Object object) {
        if(object instanceof String) {
            String messageReceived = (String)object;
             System.out.println("message posted to the sampleQueue is ===========> "+messageReceived);
        }else {
            System.out.println("object is not of type string");
        }

    }
}
