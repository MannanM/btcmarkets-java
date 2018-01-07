package com.mannanlive.btcmarkets.domain.trading;

import com.mannanlive.btcmarkets.domain.Currency;
import com.mannanlive.btcmarkets.domain.Instrument;
import com.mannanlive.btcmarkets.domain.Market;

public class OrderHistoryRequest extends Market {
    private long limit = 10;
    private long since = 1;

    public OrderHistoryRequest() {
    }

    public OrderHistoryRequest(Instrument instrument, Currency currency) {
        super(instrument, currency);
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public long getSince() {
        return since;
    }

    public void setSince(long since) {
        this.since = since;
    }
}
