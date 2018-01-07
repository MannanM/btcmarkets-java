package com.mannanlive.btcmarkets.domain.marketdata;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Trade {
    @JsonProperty("tid")
    private long id;
    private double amount;
    private double price;
    @JsonProperty("date")
    private long timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Trade{id=" + id + ", amount=" + amount + ", price=" + price + ", timestamp=" + timestamp + '}';
    }
}
