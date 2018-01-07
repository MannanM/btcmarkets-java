package com.mannanlive.btcmarkets.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mannanlive.btcmarkets.domain.trading.order.OrderSide;
import com.mannanlive.btcmarkets.domain.trading.order.OrderStatus;
import com.mannanlive.btcmarkets.domain.trading.order.OrderType;
import com.mannanlive.btcmarkets.domain.trading.OrderHistoryResponse;
import com.mannanlive.btcmarkets.domain.trading.PlacedOrder;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNull;

public class OrderHistoryResponseTest {
    @Test
    public void canDeserialiseSampleResponse() throws IOException {
        OrderHistoryResponse response = new ObjectMapper().readValue(
                "{\"success\":true,\"errorCode\":null,\"errorMessage\":null,\"orders\":["
                        + "{\"id\":1003245675,\"currency\":\"AUD\",\"instrument\":\"BTC\",\"orderSide\":\"Bid\","
                        + "\"ordertype\":\"Limit\",\"creationTime\":1378862733366,\"status\":\"Placed\","
                        + "\"errorMessage\":null,\"price\":13000000000,\"volume\":10000000,\"openVolume\":10000000,"
                        + "\"clientRequestId\":null,\"trades\":[]},{\"id\":4345675,\"currency\":\"AUD\","
                        + "\"instrument\":\"BTC\",\"orderSide\":\"Ask\",\"ordertype\":\"Limit\",\""
                        + "creationTime\":1378636912705,\"status\":\"Fully Matched\",\"errorMessage\":null,"
                        + "\"price\":13000000000,\"volume\":10000000,\"openVolume\":0,\"clientRequestId\":null,"
                        + "\"trades\":[{\"id\":5345677,\"creationTime\":1378636913151,\"description\":null,"
                        + "\"price\":13000000000,\"volume\":10000000,\"fee\":100000}]}]}", OrderHistoryResponse.class);

        assertThat(response.isSuccess(), is(true));
        assertNull(response.getErrorCode());
        assertNull(response.getErrorMessage());

        PlacedOrder firstOrder = response.getOrders().get(0);
        assertThat(firstOrder.getId(), is(1003245675L));
        assertThat(firstOrder.getCurrency(), is(Currency.AUD));
        assertThat(firstOrder.getInstrument(), is(Instrument.BTC));
        assertThat(firstOrder.getSide(), is(OrderSide.BID));
        assertThat(firstOrder.getType(), is(OrderType.LIMIT));
        assertThat(firstOrder.getCreationTime(), is(new Date(1378862733366L)));
        assertThat(firstOrder.getStatus(), is(OrderStatus.PLACED));
        assertThat(firstOrder.getPrice(), is(13000000000L));
        assertThat(firstOrder.getVolume(), is(10000000L));
        assertThat(firstOrder.getOpenVolume(), is(10000000L));
        assertNull(firstOrder.getErrorMessage());
        assertNull(firstOrder.getClientRequestId());
    }
}
