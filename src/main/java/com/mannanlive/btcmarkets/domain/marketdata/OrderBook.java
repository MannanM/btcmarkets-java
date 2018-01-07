package com.mannanlive.btcmarkets.domain.marketdata;

import com.mannanlive.btcmarkets.domain.Market;

import java.util.List;

public class OrderBook extends Market {
    private long timestamp;
    private List<List<Long>> asks;
    private List<List<Long>> bids;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public List<List<Long>> getAsks() {
        return asks;
    }

    public void setAsks(List<List<Long>> asks) {
        this.asks = asks;
    }

    public List<List<Long>> getBids() {
        return bids;
    }

    public void setBids(List<List<Long>> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "OrderBook{timestamp=" + timestamp + ", asks=" + asks + ", bids=" + bids + "} " + super.toString();
    }
}
