package com.mannanlive.btcmarkets.domain.fundtransfer;

import com.mannanlive.btcmarkets.domain.Response;

public class WithdrawResponse extends Response {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString() + status + "'}";
    }
}
