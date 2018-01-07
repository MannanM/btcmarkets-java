package com.mannanlive.btcmarkets.domain.trading.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderSide {
    @JsonProperty("Ask")
    ASK,
    @JsonProperty("Bid")
    BID
}