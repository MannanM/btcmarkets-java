package com.mannanlive.btcmarkets.domain.trading;

import com.mannanlive.btcmarkets.domain.Response;

public class PlaceOrderResponse extends Response {
    private long id;
    private String clientRequestId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }
}
