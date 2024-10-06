package com.epam.microservices.currency_exchange_service;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("sample")
    //@Retry(name = "sample-api",fallbackMethod = "hardCoded")
    @CircuitBreaker(name = "sample-api",fallbackMethod = "hardCoded")
//    @RateLimiter(name = "default")
//    @Bulkhead(name = "default")
    public String method(){
        logger.info("sample api call received");
//        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/dummy",String.class);
//        return entity.getBody();
        return "sample hio";
    }


    public String hardCoded(Exception exception){
        return "fallback-active";
    }
}
