package com.mannanlive.btcmarkets.repository;

import com.mannanlive.btcmarkets.domain.Currency;
import com.mannanlive.btcmarkets.domain.Instrument;
import com.mannanlive.btcmarkets.domain.marketdata.MarketValue;
import com.mannanlive.btcmarkets.domain.marketdata.OrderBook;
import com.mannanlive.btcmarkets.domain.marketdata.Trade;
import com.mannanlive.btcmarkets.domain.trading.order.Order;
import com.mannanlive.btcmarkets.domain.trading.order.OrderSide;
import com.mannanlive.btcmarkets.domain.trading.order.OrderType;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static com.mannanlive.btcmarkets.domain.Currency.AUD;
import static com.mannanlive.btcmarkets.domain.Instrument.BTC;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefaultUnauthenticatedBtcMarketsDaoTest {
    @Test
    public void testGetMarketValue() {
        MarketValue actual = new DefaultUnauthenticatedBtcMarketsDao().getMarketValue(BTC, AUD);
        assertEquals("BTC", actual.getInstrument().toString());
        assertEquals("AUD", actual.getCurrency().toString());
        assertTrue(actual.getBestAsk() > 1000f);
        assertTrue(actual.getBestBid() > 1000f);
        assertTrue(actual.getLastPrice() > 1000f);
        assertTrue(actual.getVolume24h() > 10f);
        assertTrue(actual.getTimestamp() <= new Date().getTime());
    }

    @Test
    public void testGetOrderBook() {
        OrderBook actual = new DefaultUnauthenticatedBtcMarketsDao().getOrderBook(BTC, AUD);
        assertEquals("BTC", actual.getInstrument().toString());
        assertEquals("AUD", actual.getCurrency().toString());
        assertEquals(200, actual.getAsks().size());
        assertEquals(200, actual.getBids().size());
        assertEquals(actual.getAsks().get(0).size(), 2);
        assertEquals(actual.getBids().get(0).size(), 2);
        assertTrue(actual.getTimestamp() <= new Date().getTime());
    }

    @Test
    public void testGetTrades() {
        List<Trade> actual = new DefaultUnauthenticatedBtcMarketsDao().getTrades(BTC, AUD);
        assertEquals(500, actual.size());
        assertTrue(actual.get(0).getId() > 0);
        assertTrue(actual.get(0).getAmount() > 0);
        assertTrue(actual.get(0).getTimestamp() > 0);
        assertTrue(actual.get(0).getTimestamp() <= new Date().getTime());
    }

    @Test
    public void testGetTradesWithSince() {
        List<Trade> actual = new DefaultUnauthenticatedBtcMarketsDao().getTrades(BTC, AUD, Long.MAX_VALUE);
        assertEquals(true, actual.isEmpty());
    }
}
