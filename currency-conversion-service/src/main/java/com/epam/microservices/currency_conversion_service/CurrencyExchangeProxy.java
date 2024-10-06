package com.epam.microservices.currency_conversion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
    @GetMapping("exchange/{from}/{to}")
    public CurrencyConversion retrieve(
            @PathVariable String from,
            @PathVariable String to
    );
}
