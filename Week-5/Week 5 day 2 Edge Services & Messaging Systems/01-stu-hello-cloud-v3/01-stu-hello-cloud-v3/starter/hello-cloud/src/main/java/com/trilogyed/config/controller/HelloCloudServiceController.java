package com.trilogyed.config.controller;

import com.trilogyed.config.util.feign.QuoteClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Step 4: Modify the Controller
//Finally, we will modify the controller to use the Feign client instead of the RestTemplate for interaction with the random-greeting-service.
@RestController
@RefreshScope
public class HelloCloudServiceController {

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${quoteServiceName}")
//    private String quoteServiceName;
//
//    @Value("${serviceProtocol}")
//    private String serviceProtocol;
//
//    @Value("${servicePath}")
//    private String servicePath;
//
//    @Value("${officialGreeting}")
//    private String officialGreeting;

    @Autowired
    private final QuoteClient quoteClient;

    public HelloCloudServiceController(QuoteClient quoteClient){
        this.quoteClient = quoteClient;
    }

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String helloCloud() {
        return "Here's your quote " + quoteClient.getRandomQuote();

//        List<ServiceInstance> instances = discoveryClient.getInstances(quoteServiceName);
//
//        String quoteServiceUri = serviceProtocol + instances.get(0).getHost() + ":" + instances.get(0).getPort() + servicePath;
//
//        String quote = restTemplate.getForObject(quoteServiceUri, String.class);
//
//        return quote;
    }
}
