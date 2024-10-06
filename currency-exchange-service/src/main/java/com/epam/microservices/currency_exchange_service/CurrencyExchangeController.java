package com.epam.microservices.currency_exchange_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;

    @GetMapping("exchange/{from}/{to}")
    public CurrencyExchange retrieve(
            @PathVariable String from,
            @PathVariable String to
    ){
        //CurrencyExchange currencyExchange =  new CurrencyExchange(1000L,from,to, BigDecimal.valueOf(50));
        CurrencyExchange currencyExchange = currencyExchangeRepository.findByFromAndTo(from,to);
        String port = environment.getProperty("local.server.port");

        if(currencyExchange == null){
            throw new RuntimeException("From and two is not valid");
        }
        currencyExchange.setEnvironment(port);
        currencyExchangeRepository.findByFromAndTo(from,to);
        return currencyExchange;
    }
}
