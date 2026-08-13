package com.javabro.spring_boot_learning.controller;

import com.javabro.spring_boot_learning.service.SpringTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringTestController {


    /*@Autowired
    SpringTestService springTestService;


    @GetMapping("spring-test")
    public ResponseEntity<String> getString() {
        return ResponseEntity.status(200).body(springTestService.getString());
    }*/
}
