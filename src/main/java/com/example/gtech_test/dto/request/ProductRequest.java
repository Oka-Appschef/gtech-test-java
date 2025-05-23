package com.example.gtech_test.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ProductRequest {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("product_name")
    private String productName;
    @JsonProperty("created_at")
    private Date createdAt;
    @JsonProperty("updated_at")
    private Date updatedAt;

    public ProductRequest() {
    }

    public ProductRequest(Integer id, String productName, Date createdAt, Date updatedAt) {
        this.id = id;
        this.productName = productName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
