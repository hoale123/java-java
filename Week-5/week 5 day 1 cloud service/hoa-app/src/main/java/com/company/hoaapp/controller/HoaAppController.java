package com.company.hoaapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//component
@RefreshScope
public class HoaAppController {
    @Value("${my.welcome.message}")//read the properties configuration
    private String officialGreeting;

    @GetMapping(value = "/hello")
    public String sayHelloFromTheCloud(){
        return "... here we go... " + officialGreeting;
    }
}
