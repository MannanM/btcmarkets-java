package com.mannanlive.btcmarkets.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mannanlive.btcmarkets.domain.trading.OrderHistoryRequest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class OrderHistoryRequestTest {
    @Test
    public void initialisesDefaultsAndOrderedCorrectly() throws JsonProcessingException {
        OrderHistoryRequest request = new OrderHistoryRequest(Instrument.BTC, Currency.AUD);
        String result = new ObjectMapper().writeValueAsString(request);

        assertThat(result, is("{\"currency\":\"AUD\",\"instrument\":\"BTC\",\"limit\":10,\"since\":1}"));
    }
}
