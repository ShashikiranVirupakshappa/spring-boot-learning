package com.javabro.spring_boot_learning.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {
    public String get() {
        System.out.println("sampleservice get called");
        return "get";
    }
}
