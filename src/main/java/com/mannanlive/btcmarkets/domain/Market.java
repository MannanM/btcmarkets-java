package com.mannanlive.btcmarkets.domain;

import com.mannanlive.btcmarkets.domain.Currency;
import com.mannanlive.btcmarkets.domain.Instrument;

public class Market {
    private Currency currency;
    private Instrument instrument;

    public Market() {
    }

    public Market(Instrument instrument, Currency currency) {
        this.instrument = instrument;
        this.currency = currency;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Market{currency=" + currency + ", instrument=" + instrument + '}';
    }
}