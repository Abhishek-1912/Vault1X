package com.example.Vault1X.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.Vault1X.enums.CurrencyType;
import com.example.Vault1X.enums.TransactionalStatus;
import com.example.Vault1X.enums.TransactionalType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transactions")

public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;
    @ManyToOne
    @JoinColumn(name = "from_wallet_id")
    private Wallet fromWallet;
    @ManyToOne
    @JoinColumn(name = "to_wallet_id")
    private Wallet toWallet;
    private BigDecimal amount;
    private CurrencyType currency;
    private TransactionalType type;
    private String description;
    private TransactionalStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime completedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    public Transactions() {
        this.completedAt = LocalDateTime.now();
        this.status = TransactionalStatus.PENDING;
    }

    public Transactions(BigDecimal amount, TransactionalType type, Users user) {
        this();
        this.amount = amount;
        this.type = type;
        this.user = user;
    }

    public Long getId() {
        return transactionId;
    }

    public void setuserId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Wallet getfromWallet() {
        return fromWallet;
    }

    public void setfromWallet(Wallet fromWallet) {
        this.fromWallet = fromWallet;
    }

    public Wallet gettoWallet() {
        return toWallet;
    }

    public void setToWallet(Wallet toWallet) {
        this.toWallet = toWallet;
    }

    public BigDecimal getamount() {
        return amount;
    }

    public void setamount(BigDecimal amount) {
        this.amount = amount;
    }

    public CurrencyType getcurrency() {
        return currency;
    }

    public void setcurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public TransactionalType gettype() {
        return type;
    }

    public void settype(TransactionalType type) {
        this.type = type;
    }

    public String getdescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionalStatus getstatus() {
        return status;
    }

    public void setstatus(TransactionalStatus status) {
        this.status = status;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

}
