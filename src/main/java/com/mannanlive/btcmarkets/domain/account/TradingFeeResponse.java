package com.mannanlive.btcmarkets.domain.account;

import com.mannanlive.btcmarkets.domain.Response;

import java.text.NumberFormat;

import static com.mannanlive.btcmarkets.domain.trading.order.Order.RATIO;

public class TradingFeeResponse extends Response {
    private long tradingFeeRate;
    private long volume30Day;

    public Double getTradingFeeRateAsPercent() {
        return tradingFeeRate / RATIO.doubleValue();
    }

    public String getVolume30DayAsAud() {
        return NumberFormat.getCurrencyInstance().format(volume30Day / RATIO.doubleValue()) + " AUD";
    }

    public long getTradingFeeRate() {
        return tradingFeeRate;
    }

    public void setTradingFeeRate(long tradingFeeRate) {
        this.tradingFeeRate = tradingFeeRate;
    }

    public long getVolume30Day() {
        return volume30Day;
    }

    public void setVolume30Day(long volume30Day) {
        this.volume30Day = volume30Day;
    }

    @Override
    public String toString() {
        return super.toString() + "tradingFeeRate=" + getTradingFeeRateAsPercent()
                + ", volume30Day=" + getVolume30DayAsAud() + "}";
    }
}
