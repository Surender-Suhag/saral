package com.test.frmw.saral.components;

import java.util.Map;

public class ComponentKeyword {
    private String keywordName;
    private int orderNumber;
    private Map<String,String> paramNameValueMap;

    public String getKeywordName() {
        return keywordName;
    }

    public void setKeywordName(String keywordName) {
        this.keywordName = keywordName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Map<String, String> getParamNameValueMap() {
        return paramNameValueMap;
    }

    public void setParamNameValueMap(Map<String, String> paramNameValueMap) {
        this.paramNameValueMap = paramNameValueMap;
    }
}
