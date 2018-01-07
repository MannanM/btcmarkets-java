package com.mannanlive.btcmarkets.domain.trading.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderType {
    @JsonProperty("Market")
    MARKET,

    @JsonProperty("Limit")
    LIMIT
}
