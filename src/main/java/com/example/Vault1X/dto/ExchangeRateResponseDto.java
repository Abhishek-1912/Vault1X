package com.example.Vault1X.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import com.example.Vault1X.enums.CurrencyType;

public class ExchangeRateResponseDto {
    private CurrencyType base;
    private LocalDate date;
    private Map<String, BigDecimal> rates;

    public ExchangeRateResponseDto() {

    }

    public CurrencyType getBase() {
        return base;
    }

    public void setBase(CurrencyType base) {
        this.base = base;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<String, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(Map<String, BigDecimal> rates) {
        this.rates = rates;
    }
}
