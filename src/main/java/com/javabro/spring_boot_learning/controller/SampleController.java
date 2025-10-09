package com.javabro.spring_boot_learning.controller;

import com.javabro.spring_boot_learning.model.Employee;
import com.javabro.spring_boot_learning.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("test")
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @Value("${testing.value}")
    private String injectedValue;

    ApplicationContext applicationContext;

    SampleService sampleService;

    RabbitTemplate rabbitTemplate;

    public SampleController(ApplicationContext applicationContext, SampleService sampleService, RabbitTemplate rabbitTemplate) {
        logger.debug("samplecontroller logger debug working");
        this.applicationContext = applicationContext;
        this.sampleService = sampleService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping(name = "getMethod", path="get")
    public String getMeth() {
        System.out.println(applicationContext);
        System.out.println("injectedvalue ======> "+injectedValue);
        return sampleService.get();
    }

    @GetMapping("get2/{firstName}/{lastName}")
    public String getPassedName(@PathVariable("firstName") String fName, @PathVariable("lastName") String lName) {
        boolean flag = false;
        System.out.println(applicationContext);
        //flag = true;
        if(flag)
            throw new RuntimeException("error occurred");

        rabbitTemplate.convertAndSend("testExchange", "sq", fName+" "+lName);

        return fName + " " + lName;
    }

    @PostMapping("employee")
    public String postComplexTypeToRabbitQueue(@RequestBody Employee employee) {
        logger.debug("postComplexTypeToRabbitQueue called");
        logger.debug(employee.getFirstName());
        rabbitTemplate.convertAndSend("testExchange", "eq", employee);
        return "posted employee data to queue";

    }
}
