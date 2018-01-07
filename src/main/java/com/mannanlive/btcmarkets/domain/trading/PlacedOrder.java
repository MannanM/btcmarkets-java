package com.mannanlive.btcmarkets.domain.trading;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mannanlive.btcmarkets.domain.trading.order.Order;
import com.mannanlive.btcmarkets.domain.trading.order.OrderStatus;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlacedOrder extends Order {
    private long id;
    private Date creationTime;
    private OrderStatus status;
    private String errorMessage;
    private long openVolume;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Long getOpenVolume() {
        return openVolume;
    }

    public void setOpenVolume(Long openVolume) {
        this.openVolume = openVolume;
    }
}
