package com.javabro.spring_boot_learning.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

//@FeignClient(name = "spring-test", url = "${application.services.spring-test.url}")
public interface SpringTestClient {
    /*@GetMapping("test")
    public String getStrResponse();*/
}
