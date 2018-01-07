package com.mannanlive.btcmarkets.domain;

public class Response {
    private boolean success;
    private Integer errorCode;
    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        String result = "Response{success=" + success;
        if (errorCode != null && errorCode > 0) {
            result += ", errorCode=" + errorCode + ", errorMessage='" + errorMessage + '\'';
        }
        return result + ", ";
    }
}
