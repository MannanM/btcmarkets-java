package com.mannanlive.btcmarkets.repository;

import com.mannanlive.btcmarkets.domain.Currency;
import com.mannanlive.btcmarkets.domain.Instrument;
import com.mannanlive.btcmarkets.domain.marketdata.MarketValue;
import com.mannanlive.btcmarkets.domain.marketdata.OrderBook;
import com.mannanlive.btcmarkets.domain.marketdata.Trade;

import java.util.List;

public interface UnauthenticatedBtcMarketsDao {

    MarketValue getMarketValue(Instrument instrument, Currency currency);

    OrderBook getOrderBook(Instrument instrument, Currency currency);

    List<Trade> getTrades(Instrument instrument, Currency currency);

    List<Trade> getTrades(Instrument instrument, Currency currency, long since);
}
