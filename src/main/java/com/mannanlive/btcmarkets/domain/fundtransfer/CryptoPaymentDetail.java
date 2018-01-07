package com.mannanlive.btcmarkets.domain.fundtransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CryptoPaymentDetail {
    private String address;
    @JsonProperty("txId")
    private String transationId;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTransationId() {
        return transationId;
    }

    public void setTransationId(String transationId) {
        this.transationId = transationId;
    }

    @Override
    public String toString() {
        return "CryptoPaymentDetail{address='" + address + '\'' + ", transationId='" + transationId + "'}";
    }
}
