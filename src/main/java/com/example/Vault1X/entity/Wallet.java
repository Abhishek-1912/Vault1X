package com.example.Vault1X.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.Vault1X.enums.CurrencyType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Wallet")

public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wallet_id;
    private BigDecimal balance = BigDecimal.ZERO;
    private CurrencyType currency;// enum
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive;
    // private Long userId;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private Users user;

    public Wallet() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public Wallet(BigDecimal balance, CurrencyType currency, Users user) {
        this();
        this.balance = balance;
        this.currency = currency;
        this.user = user;
    }

    public Long getwallet_id() {
        return wallet_id;
    }

    public void setwallet_id(Long wallet_id) {
        this.wallet_id = wallet_id;
    }

    public BigDecimal getbalance() {
        return balance;
    }

    public void setbalance(BigDecimal balance) {
        this.balance = balance;
    }

    public CurrencyType getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public LocalDateTime getcreatedAt() {
        return createdAt;
    }

    public void setcreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getupdatedAt() {
        return updatedAt;
    }

    public void setupdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setisActive(boolean active) {
        isActive = active;
    }

    public Users getuser() {
        return user;
    }

    public void setuser(Users user) {
        this.user = user;
    }

}
