package com.mannanlive.btcmarkets.domain.account;

public class CurrencyBalance {
    private long balance;
    private long pendingFunds;
    private String currency;

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getPendingFunds() {
        return pendingFunds;
    }

    public void setPendingFunds(long pendingFunds) {
        this.pendingFunds = pendingFunds;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Currency{balance=" + balance + ", pendingFunds=" + pendingFunds + ", currency='" + currency + "'}";
    }
}
