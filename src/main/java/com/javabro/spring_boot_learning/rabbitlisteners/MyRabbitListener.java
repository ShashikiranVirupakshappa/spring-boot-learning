package com.javabro.spring_boot_learning.rabbitlisteners;

import com.javabro.spring_boot_learning.model.Employee;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MyRabbitListener {

    @RabbitListener(queues = "sampleQueue")
    public void consume(String message) {
        System.out.println("message posted to the sampleQueue is ===========> "+message);
    }

    @RabbitListener(queues = "employeeQueue")
    public void consume(Employee employee) {
        System.out.println("message posted to the employeeQueue is ===========> "+employee.getFirstName());
    }
}
