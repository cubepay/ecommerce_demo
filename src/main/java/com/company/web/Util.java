package com.company.web;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by tsagita on 7/3/15.
 */
public class Util {
    private String paymentLoggingUrl;

    private String transactionType;

    public String getPaymentLoggingUrl() {
        return paymentLoggingUrl;
    }

    public void setPaymentLoggingUrl(String paymentLoggingUrl) {
        this.paymentLoggingUrl = paymentLoggingUrl;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getURLWithContextPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
