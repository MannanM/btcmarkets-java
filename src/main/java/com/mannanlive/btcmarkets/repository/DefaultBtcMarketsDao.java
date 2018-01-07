package com.mannanlive.btcmarkets.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mannanlive.btcmarkets.domain.Currency;
import com.mannanlive.btcmarkets.domain.Instrument;
import com.mannanlive.btcmarkets.domain.fundtransfer.WithdrawCrypto;
import com.mannanlive.btcmarkets.domain.fundtransfer.WithdrawEft;
import com.mannanlive.btcmarkets.domain.account.CurrencyBalance;
import com.mannanlive.btcmarkets.domain.account.TradingFeeResponse;
import com.mannanlive.btcmarkets.domain.fundtransfer.WithdrawHistoryResponse;
import com.mannanlive.btcmarkets.domain.fundtransfer.WithdrawResponse;
import com.mannanlive.btcmarkets.domain.trading.CancelOrdersResponse;
import com.mannanlive.btcmarkets.domain.trading.MultipleOrdersRequest;
import com.mannanlive.btcmarkets.domain.trading.OrderHistoryRequest;
import com.mannanlive.btcmarkets.domain.trading.OrderHistoryResponse;
import com.mannanlive.btcmarkets.domain.trading.PlaceOrderResponse;
import com.mannanlive.btcmarkets.domain.trading.order.Order;
import com.mannanlive.btcmarkets.service.RequestSigningService;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DefaultBtcMarketsDao extends DefaultUnauthenticatedBtcMarketsDao implements BtcMarketsDao {
    private static final String APIKEY_HEADER = "apikey";
    private static final String TIMESTAMP_HEADER = "timestamp";
    private static final String SIGNATURE_HEADER = "signature";
    private static final String ENCODING = "UTF-8";

    private final String apiKey;
    private final RequestSigningService service;

    public DefaultBtcMarketsDao(String apiKey, String privateKey) {
        this.apiKey = apiKey;
        service = new RequestSigningService(privateKey);
    }

    @Override
    public List<CurrencyBalance> getAccountBalance() {
        CurrencyBalance[] currencies = (CurrencyBalance[]) sendAndReceive(null, "/account/balance", CurrencyBalance[].class);
        return Arrays.asList(currencies);
    }

    @Override
    public TradingFeeResponse getFee(Instrument instrument, Currency currency) {
        String path = String.format("/account/%s/%s/tradingfee", instrument, currency);
        return (TradingFeeResponse) sendAndReceive(null, path, TradingFeeResponse.class);
    }

    @Override
    public OrderHistoryResponse getOrders(Long... orderIds) {
        MultipleOrdersRequest request = new MultipleOrdersRequest(orderIds);
        return (OrderHistoryResponse) sendAndReceive(request, "/order/detail", OrderHistoryResponse.class);
    }

    @Override
    public OrderHistoryResponse getOrders(OrderHistoryRequest request) {
        return (OrderHistoryResponse) sendAndReceive(request, "/order/history", OrderHistoryResponse.class);
    }

    @Override
    public OrderHistoryResponse getActiveOrders(OrderHistoryRequest request) {
        return (OrderHistoryResponse) sendAndReceive(request, "/order/open", OrderHistoryResponse.class);
    }

    @Override
    public PlaceOrderResponse placeOrder(Order order) {
        return (PlaceOrderResponse) sendAndReceive(order, "/order/create", PlaceOrderResponse.class);
    }

    @Override
    public CancelOrdersResponse cancelOrders(Long... orderIds) {
        MultipleOrdersRequest request = new MultipleOrdersRequest(orderIds);
        return (CancelOrdersResponse) sendAndReceive(request, "/order/cancel", CancelOrdersResponse.class);
    }

    @Override
    public WithdrawResponse withdraw(WithdrawCrypto request) {
        return (WithdrawResponse) sendAndReceive(request, "/fundtransfer/withdrawCrypto", WithdrawResponse.class);
    }

    @Override
    public WithdrawResponse withdraw(WithdrawEft request) {
        return (WithdrawResponse) sendAndReceive(request, "/fundtransfer/withdrawEFT", WithdrawResponse.class);
    }

    @Override
    public WithdrawHistoryResponse getWithdrawHistory() {
        return (WithdrawHistoryResponse) sendAndReceive(null, "/fundtransfer/history", WithdrawHistoryResponse.class);
    }

    private Object sendAndReceive(Object request, String orderHistoryPath, Class clazz) {
        String response = sendRequest(orderHistoryPath, transformObjectToJsonString(request));
        return transformJsonStringToObject(response, clazz);
    }

    private String sendRequest(String path, String postData) {
        // get the current timestamp. It's best to use ntp or similar services in order to sync your server time
        String timestamp = Long.toString(System.currentTimeMillis());

        String signature = service.signRequest(path, null, postData, timestamp);

        // full url path
        String url = BASE_URL + path;

        return executeHttpRequest(postData, url, apiKey, signature, timestamp);
    }

    private static String executeHttpRequest(String postData, String url, String apiKey,
                                             String signature, String timestamp) {

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {
            HttpRequestBase request = createGetOrPostRequest(postData, url);
            addHeaders(apiKey, signature, timestamp, request);

            // execute http request
            HttpResponse httpResponse = httpClient.execute(request);

            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                System.err.println(httpResponse);
                throw new RuntimeException(httpResponse.getStatusLine().getReasonPhrase());
            }
            // return JSON results as String
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            return responseHandler.handleResponse(httpResponse);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("unable to execute json call:" + e);
        }
    }

    private static void addHeaders(String apiKey, String signature, String timestamp, HttpRequestBase request) {
        // Set http headers
        request.addHeader("Accept", "*/*");
        request.addHeader("Accept-Charset", ENCODING);
        request.addHeader("Content-Type", "application/json");

        // Add signature, timestamp and apiKey to the http header
        request.addHeader(SIGNATURE_HEADER, signature);
        request.addHeader(APIKEY_HEADER, apiKey);
        request.addHeader(TIMESTAMP_HEADER, timestamp);
    }

    private static HttpRequestBase createGetOrPostRequest(String postData, String url) {
        if (postData == null) {
            return new HttpGet(url);
        }
        // post any data that needs to go with http request.
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(postData, ENCODING));
        return httpPost;
    }

    private String transformObjectToJsonString(Object object) {
        if (object != null) {
            try {
                String result = objectMapper.writeValueAsString(object);
                System.out.println(result);
                return result;
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    private Object transformJsonStringToObject(String response, Class<?> clazz) {
        try {
            System.out.println(response);
            return objectMapper.readValue(response, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
