package com.mannanlive.btcmarkets.domain.trading;

import com.mannanlive.btcmarkets.domain.Response;

import java.util.List;

public class CancelOrdersResponse extends Response {
    public List<PlaceOrderResponse> responses;

    public List<PlaceOrderResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<PlaceOrderResponse> responses) {
        this.responses = responses;
    }
}
