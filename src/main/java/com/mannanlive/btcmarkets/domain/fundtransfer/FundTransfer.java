package com.mannanlive.btcmarkets.domain.fundtransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class FundTransfer {
    private String status;
    @JsonProperty("fundTransferId")
    private long id;
    private String description;
    private Date creationTime;
    private Date lastUpdate;
    private String currency;
    private long amount;
    private long fee;
    @JsonProperty("transferType")
    private String type;
    private String errorMessage;
    @JsonProperty("cryptoPaymentDetail")
    private CryptoPaymentDetail detail;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CryptoPaymentDetail getDetail() {
        return detail;
    }

    public void setDetail(CryptoPaymentDetail cryptoPaymentDetail) {
        this.detail = cryptoPaymentDetail;
    }

    @Override
    public String toString() {
        return "FundTransfer{status='" + status + '\'' + ", id=" + id + ", description='" + description + '\''
                + ", creationTime=" + creationTime + ", lastUpdate=" + lastUpdate + ", currency='" + currency + '\''
                + ", amount=" + amount + ", fee=" + fee + ", type='" + type + '\'' + ", errorMessage='"
                + errorMessage + '\'' + ", detail=" + detail + '}';
    }
}
