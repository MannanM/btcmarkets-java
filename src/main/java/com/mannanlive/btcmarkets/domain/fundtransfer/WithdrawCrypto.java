package com.mannanlive.btcmarkets.domain.fundtransfer;

import com.mannanlive.btcmarkets.domain.Instrument;

public class WithdrawCrypto {
    private long amount;
    private String address;
    private Instrument currency;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Instrument getCurrency() {
        return currency;
    }

    public void setCurrency(Instrument currency) {
        this.currency = currency;
    }
}
