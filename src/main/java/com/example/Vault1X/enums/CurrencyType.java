package com.example.Vault1X.enums;

public enum CurrencyType { // usd,euro,btc,ltc - usd-usd btc-btc euro-euro ltc-ltc (false)
    INR("Indian Ruppee", "R", false),
    USD("US Dollar", "$", false),
    EUR("EURO", "E", false),
    BTC("Bitcoin", "B", true),
    LTC("Litecoin", "L", true);

    private final String displayName;
    private final String symbol;
    private final boolean isCrypto;

    CurrencyType(String displayName, String symbol, boolean isCrypto) {
        this.displayName = displayName;
        this.symbol = symbol;
        this.isCrypto = isCrypto;
    }

    public String getdisplayName() {
        return displayName;
    }

    public String getsymbol() {
        return symbol;
    }

    public boolean isCrypto() {
        return isCrypto;
    }

}
