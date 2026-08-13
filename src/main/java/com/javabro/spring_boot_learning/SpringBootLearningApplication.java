package com.javabro.spring_boot_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableFeignClients
public class SpringBootLearningApplication {

	public static void main(String[] args) {
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SpringBootLearningApplication.class, args);
        Object sampleController = configurableApplicationContext.getBean("sampleController");
        System.out.println(sampleController);
    }

}
