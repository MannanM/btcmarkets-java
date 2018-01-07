package com.mannanlive.btcmarkets.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mannanlive.btcmarkets.domain.trading.order.Order;
import com.mannanlive.btcmarkets.domain.trading.order.OrderSide;
import com.mannanlive.btcmarkets.domain.trading.order.OrderType;
import org.junit.Test;

import static com.mannanlive.btcmarkets.domain.Currency.AUD;
import static com.mannanlive.btcmarkets.domain.Instrument.BTC;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OrderTest {
    @Test
    public void canSerialiseSampleRequest() throws JsonProcessingException {
        Order order = new Order();
        order.setCurrency(AUD);
        order.setInstrument(BTC);
        order.setPrice(100L);
        order.setVolume(200L);
        order.setSide(OrderSide.ASK);
        order.setType(OrderType.LIMIT);
        order.setClientRequestId("123");
        String actual = new ObjectMapper().writeValueAsString(order);
        String expected = getNewOrderString("AUD", "BTC", 100L, 200L, "Ask", "Limit", "123");
        assertThat(actual, is(expected));
    }

    private String getNewOrderString(String currency, String instrument, long price, long volume,
                                     String orderSide, String orderType, String clientRequestId) {
        // These need to be in this specific order for the API to work
        return "{\"currency\":\"" + currency + "\",\"instrument\":\"" + instrument + "\",\"price\":" + price
                + ",\"volume\":" + volume + ",\"orderSide\":\"" + orderSide + "\",\"ordertype\":\"" + orderType
                + "\",\"clientRequestId\":\"" + clientRequestId + "\"}";
    }
}
