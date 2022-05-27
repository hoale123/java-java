package com.company.hoalerandomquoteservice.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RefreshScope
public class RandomQuoteController {

    List<String> quotes = Arrays.asList(
            "To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge. —Grace Hopper",
            "Programs must be written for people to read, and only incidentally for machines to execute. —Hal Ableson",
            "Don't call me the mother of the internet. —Radia Perlman",
            "When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline. —Margaret Hamilton",
            "Machines take me by surprise with great frequency. —Alan Turing",
            "The function of good software is to make the complex appear simple. —Grady Booch",
            "An API that isn't comprehensible isn't usable. —James Gosling",
            "I'm not a great programmer; I'm just a good programmer with great habits. —Martin Fowler"
    );

    @Value("${my.welcome.message}")//read the properties configuration
    private String officialGreeting;

    @GetMapping(value = "/quote")
    public String sayHelloFromTheCloud(){
        return "... here we go... " + officialGreeting;
    }
}
