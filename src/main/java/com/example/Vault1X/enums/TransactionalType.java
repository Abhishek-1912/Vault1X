package com.example.Vault1X.enums;

public enum TransactionalType {
    DEPOSIT("Deposit"),
    WITHDRAWAL("Withdrawal"),
    TRANSFER("Transfer"),
    CONVERSION("Conversion"),
    REFUND("Refund");

    private String displayName;

    TransactionalType(String displayName) {
        this.displayName = displayName;
    }

    public String getdisplayName() {
        return displayName;
    }
}
