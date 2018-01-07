# Connecting to BTC Markets from Java

## Unauthenticated Operations

```java
public interface UnauthenticatedBtcMarketsDao {

    MarketValue getMarketValue(Instrument instrument, Currency currency);

    OrderBook getOrderBook(Instrument instrument, Currency currency);

    List<Trade> getTrades(Instrument instrument, Currency currency);

    List<Trade> getTrades(Instrument instrument, Currency currency, long since);
}
```

### Example

```java
UnauthenticatedBtcMarketsDao dao = new DefaultUnauthenticatedBtcMarketsDao();
MarketValue btcValue = dao.getMarketValue(Instrument.BTC, Currency.AUD);
System.out.println("The best asking price for BTC is currently: $" + btcValue.getBestAsk());
```

## Authenticated Operations

```java
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
```


### Example

```java
BtcMarketsDao dao = new DefaultBtcMarketsDao("api-key", "private-key");
PlaceOrderResponse response = dao.placeOrder(new Order(Instrument.BTC, Currency.AUD, 20000.00, 1.0, "request-7", OrderSide.ASK, OrderType.LIMIT));
System.out.println("The order id is: " + response.getId());
```

See more at [Mannan Live](http://mannanlive.com).