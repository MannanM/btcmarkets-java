package com.mannanlive.btcmarkets.domain.trading.order;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrderStatus {
    @JsonProperty("New")
    NEW,
    @JsonProperty("Placed")
    PLACED,
    @JsonProperty("Failed")
    FAILED,
    @JsonProperty("Error")
    ERROR,
    @JsonProperty("Cancelled")
    CANCELLED,
    @JsonProperty("Partially Cancelled")
    PARTIALLY_CANCELLED,
    @JsonProperty("Fully Matched")
    FULLY_MATCHED,
    @JsonProperty("Partially Matched")
    PARTIALLY_MATCHED
}
