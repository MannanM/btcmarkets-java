package com.mannanlive.btcmarkets.domain.fundtransfer;

import com.mannanlive.btcmarkets.domain.Response;

import java.util.List;

public class WithdrawHistoryResponse extends Response {
    private List<FundTransfer> fundTransfers;
    private Paging paging;

    public List<FundTransfer> getFundTransfers() {
        return fundTransfers;
    }

    public void setFundTransfers(List<FundTransfer> fundTransfers) {
        this.fundTransfers = fundTransfers;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    @Override
    public String toString() {
        return super.toString() + "fundTransfers=" + fundTransfers + ", paging=" + paging + "}";
    }
}
