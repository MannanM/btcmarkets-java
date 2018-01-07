package com.mannanlive.btcmarkets.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mannanlive.btcmarkets.domain.Currency;
import com.mannanlive.btcmarkets.domain.Instrument;
import com.mannanlive.btcmarkets.domain.marketdata.MarketValue;
import com.mannanlive.btcmarkets.domain.marketdata.OrderBook;
import com.mannanlive.btcmarkets.domain.marketdata.Trade;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class DefaultUnauthenticatedBtcMarketsDao implements UnauthenticatedBtcMarketsDao {
    protected static final String BASE_URL = "https://api.btcmarkets.net";
    protected static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public MarketValue getMarketValue(Instrument instrument, Currency currency) {
        return (MarketValue) sendGetAndRespond(instrument, currency, "tick", MarketValue.class);
    }

    @Override
    public OrderBook getOrderBook(Instrument instrument, Currency currency) {
        return (OrderBook) sendGetAndRespond(instrument, currency, "orderbook", OrderBook.class);
    }

    @Override
    public List<Trade> getTrades(Instrument instrument, Currency currency) {
        Trade[] trades = (Trade[]) sendGetAndRespond(instrument, currency, "trades", Trade[].class);
        return Arrays.asList(trades);
    }

    @Override
    public List<Trade> getTrades(Instrument instrument, Currency currency, long since) {
        String url = format("%s/market/%s/%s/trades?since=%d", BASE_URL, instrument, currency, since);
        Trade[] trades = (Trade[]) sendGetAndRespond(Trade[].class, url);
        return Arrays.asList(trades);
    }

    private Object sendGetAndRespond(Instrument instrument, Currency currency, String operation, Class clazz) {
        String url = format("%s/market/%s/%s/%s", BASE_URL, instrument, currency, operation);
        return sendGetAndRespond(clazz, url);
    }

    private Object sendGetAndRespond(Class clazz, String url) {
        try {
            URL src = new URL(url);
            return objectMapper.readValue(src, clazz);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
