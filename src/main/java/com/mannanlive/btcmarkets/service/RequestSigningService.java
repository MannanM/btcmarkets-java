package com.mannanlive.btcmarkets.service;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class RequestSigningService {
    private static final String ALGORITHM = "HmacSHA512";
    private final String privateKey;

    public RequestSigningService(String privateKey) {
        this.privateKey = privateKey;
    }

    public String signRequest(String uri, String queryString, String postData, String timestamp) {
        return signRequest(privateKey, buildStringToSign(uri, queryString, postData, timestamp));
    }

    private static String signRequest(String secret, String data) {
        try {
            Mac mac = Mac.getInstance(ALGORITHM);
            SecretKeySpec secretSpec = new SecretKeySpec(Base64.decodeBase64(secret), ALGORITHM);
            mac.init(secretSpec);
            return Base64.encodeBase64String(mac.doFinal(data.getBytes()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String buildStringToSign(String uri, String queryString, String postData, String timestamp) {
        // queryString must be sorted key=value& pairs
        String stringToSign = uri + "\n";
        if (queryString != null) {
            stringToSign += queryString + "\n";
        }
        stringToSign += timestamp + "\n";
        if (postData != null) {
            stringToSign += postData;
        }
        return stringToSign;
    }
}
