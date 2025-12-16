package com.example.Vault1X.enums;

public enum TransactionalStatus {
    PENDING("Pending"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    CANCELLED("Cancelled");

    private final String displayName;

    TransactionalStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getdisplayName() {
        return displayName;
    }
}