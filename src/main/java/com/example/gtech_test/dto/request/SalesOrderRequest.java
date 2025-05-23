package com.example.gtech_test.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;


public class SalesOrderRequest {

    @JsonProperty("start_month")
    private String startMonth;
    @JsonProperty("end_month")
    private String endMonth;

    public SalesOrderRequest() {
    }

    public SalesOrderRequest(String startMonth, String endMonth) {
        this.startMonth = startMonth;
        this.endMonth = endMonth;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }
}
