package com.mannanlive.btcmarkets.domain.trading.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.mannanlive.btcmarkets.domain.Currency;
import com.mannanlive.btcmarkets.domain.Instrument;
import com.mannanlive.btcmarkets.domain.Market;

import java.text.NumberFormat;

@JsonPropertyOrder(value = {"currency", "instrument", "price", "volume", "orderSide", "ordertype", "clientRequestId"})
public class Order extends Market {
    public static final Long RATIO = 100000000L;

    private long price;
    private long volume;
    private String clientRequestId;

    @JsonProperty("orderSide")
    private OrderSide side;

    @JsonProperty("ordertype")
    private OrderType type;

    //trades


    public Order() {
    }

    public Order(Instrument instrument, Currency currency, double price, double volume, String clientRequestId,
                 OrderSide side, OrderType type) {
        super(instrument, currency);
        this.price = (long) (price * RATIO);
        this.volume = (long) (volume * RATIO);
        this.clientRequestId = clientRequestId;
        this.side = side;
        this.type = type;
    }

    @JsonIgnore
    public String getTotal() {
        return NumberFormat.getCurrencyInstance().format(price / RATIO.doubleValue() * volume / RATIO.doubleValue());
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getVolume() {
        return volume;
    }

    public void setVolume(long volume) {
        this.volume = volume;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public String getClientRequestId() {
        return clientRequestId;
    }

    public void setClientRequestId(String clientRequestId) {
        this.clientRequestId = clientRequestId;
    }

    @Override
    public String toString() {
        return "{side=" + side + ", type=" + type + ", price=" + (price / RATIO.doubleValue()) + ", volume="
                + (volume / RATIO.doubleValue()) + ", total=" + getTotal() + ", clientRequestId='" + clientRequestId
                + "'} " + super.toString();
    }
}
