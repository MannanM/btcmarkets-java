package com.mannanlive.btcmarkets.domain.trading;

import com.mannanlive.btcmarkets.domain.Response;

import java.util.List;

public class OrderHistoryResponse extends Response {
    private List<PlacedOrder> orders;

    public List<PlacedOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<PlacedOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return super.toString() + "orders=" + orders + "}";
    }
}
