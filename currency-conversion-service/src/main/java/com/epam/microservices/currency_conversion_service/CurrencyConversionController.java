package com.epam.microservices.currency_conversion_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    @Autowired
    private  CurrencyExchangeProxy exchangeProxy ;

    @GetMapping("currency-conversion/{from}/{to}/{quantity}")
    public CurrencyConversion calculatedCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ){


        CurrencyConversion currencyConversion = exchangeProxy.retrieve(from, to);
        return new CurrencyConversion(currencyConversion.getId(), from,to,quantity,currencyConversion.getConversionMultiPle()
                ,quantity.multiply(currencyConversion.getConversionMultiPle()),currencyConversion.getEnvironment());
    }

}
