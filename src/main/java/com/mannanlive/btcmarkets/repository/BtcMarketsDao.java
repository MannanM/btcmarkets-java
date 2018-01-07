package com.mannanlive.btcmarkets.repository;

import com.mannanlive.btcmarkets.domain.Currency;
import com.mannanlive.btcmarkets.domain.Instrument;
import com.mannanlive.btcmarkets.domain.fundtransfer.WithdrawHistoryResponse;
import com.mannanlive.btcmarkets.domain.trading.order.Order;
import com.mannanlive.btcmarkets.domain.trading.OrderHistoryRequest;
import com.mannanlive.btcmarkets.domain.fundtransfer.WithdrawCrypto;
import com.mannanlive.btcmarkets.domain.fundtransfer.WithdrawEft;
import com.mannanlive.btcmarkets.domain.account.TradingFeeResponse;
import com.mannanlive.btcmarkets.domain.fundtransfer.WithdrawResponse;
import com.mannanlive.btcmarkets.domain.trading.CancelOrdersResponse;
import com.mannanlive.btcmarkets.domain.account.CurrencyBalance;
import com.mannanlive.btcmarkets.domain.trading.OrderHistoryResponse;
import com.mannanlive.btcmarkets.domain.trading.PlaceOrderResponse;

import java.util.List;

public interface BtcMarketsDao {

    List<CurrencyBalance> getAccountBalance();

    TradingFeeResponse getFee(Instrument instrument, Currency currency);

    OrderHistoryResponse getOrders(Long... orderIds);

    OrderHistoryResponse getOrders(OrderHistoryRequest request);

    OrderHistoryResponse getActiveOrders(OrderHistoryRequest request);

    PlaceOrderResponse placeOrder(Order order);

    CancelOrdersResponse cancelOrders(Long... orderIds);

    WithdrawResponse withdraw(WithdrawCrypto request);

    WithdrawResponse withdraw(WithdrawEft request);

    WithdrawHistoryResponse getWithdrawHistory();
}
