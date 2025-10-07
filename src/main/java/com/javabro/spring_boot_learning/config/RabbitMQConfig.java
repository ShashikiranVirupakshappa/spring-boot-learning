package com.javabro.spring_boot_learning.config;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public RabbitTemplate getRabbitMQTemplate(ConnectionFactory connectionFactory) {
        System.out.println("creating rabbitmqtemplate for asynchronous communication");
        return new RabbitTemplate(connectionFactory);
    }
}
