package com.mannanlive.btcmarkets.domain.trading;

import java.util.Arrays;
import java.util.List;

public class MultipleOrdersRequest {
    List<Long> orderIds;

    public MultipleOrdersRequest(Long[] orderIds) {
        this.orderIds = Arrays.asList(orderIds);
    }

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }
}
