package com.example.Vault1X.dto;

import java.math.BigDecimal;

import com.example.Vault1X.enums.CurrencyType;

public class ExchangeRateRequestDto {
    private CurrencyType from;
    private CurrencyType To;
    private BigDecimal amount;

    public ExchangeRateRequestDto() {

    }

    public ExchangeRateRequestDto(CurrencyType from, CurrencyType To, BigDecimal amount) {
        this.from = from;
        this.To = To;
        this.amount = amount;
    }

    public ExchangeRateRequestDto(CurrencyType from, CurrencyType To) {
        this.from = from;
        this.To = To;
    }

    public CurrencyType getFrom() {
        return from;
    }

    public void setFrom(CurrencyType from) {
        this.from = from;
    }

    public CurrencyType getTo() {
        return To;
    }

    public void setTo(CurrencyType To) {
        this.To = To;
    }

    public BigDecimal getamount() {
        return amount;
    }

    public void setamount(BigDecimal amount) {
        this.amount = amount;
    }

}