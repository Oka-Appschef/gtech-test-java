package com.example.gtech_test.dto;

public class SalesOrderReportDto {
    private Integer no;
    private Integer productId;
    private String productName;
    private String productVariant;
    private Double salesIncome;
    private Double salesMargin;

    public SalesOrderReportDto() {

    }

    public SalesOrderReportDto(Double salesMargin, Double salesIncome, String productVariant, String productName, Integer no, Integer productId) {
        this.salesMargin = salesMargin;
        this.salesIncome = salesIncome;
        this.productVariant = productVariant;
        this.productName = productName;
        this.no = no;
        this.productId = productId;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(String productVariant) {
        this.productVariant = productVariant;
    }

    public Double getSalesIncome() {
        return salesIncome;
    }

    public void setSalesIncome(Double salesIncome) {
        this.salesIncome = salesIncome;
    }

    public Double getSalesMargin() {
        return salesMargin;
    }

    public void setSalesMargin(Double salesMargin) {
        this.salesMargin = salesMargin;
    }
}
