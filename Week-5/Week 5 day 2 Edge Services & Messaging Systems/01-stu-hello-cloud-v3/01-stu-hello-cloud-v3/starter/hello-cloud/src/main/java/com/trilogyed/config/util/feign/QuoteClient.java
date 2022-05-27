package com.trilogyed.config.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "quote-service")
public interface QuoteClient {
    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String getRandomQuote();
}

//5.2 activity 1

/*
* The @FeignClient marks this interface as a Feign client. The name attribute is the name of the service this client will interact with. This name must match the name of a service registered with Eureka.*/
//The @RequestMapping annotation allows us to specify which endpoint should be called when the annotated method is invoked. In our case, a GET request will be issued to /greeting on the random-greeting-service whenever getRandomGreeting is invoked in our code.