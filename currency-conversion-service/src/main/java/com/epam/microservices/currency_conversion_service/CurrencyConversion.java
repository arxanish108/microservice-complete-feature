package com.epam.microservices.currency_conversion_service;

import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionMultiPle;
    private BigDecimal totalCalcAmount;
    private String environment;

    public CurrencyConversion() {
    }

    public CurrencyConversion(Long id, String from, String to, BigDecimal conversionMultiPle, BigDecimal quantity, BigDecimal totalCalcAmount, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiPle = conversionMultiPle;
        this.quantity = quantity;
        this.totalCalcAmount = totalCalcAmount;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiPle() {
        return conversionMultiPle;
    }

    public void setConversionMultiPle(BigDecimal conversionMultiPle) {
        this.conversionMultiPle = conversionMultiPle;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalcAmount() {
        return totalCalcAmount;
    }

    public void setTotalCalcAmount(BigDecimal totalCalcAmount) {
        this.totalCalcAmount = totalCalcAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
