package com.example.gtech_test.model;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Product")
public class Product {

    @Id
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "created_at")
    private String updatedAt;

    @OneToMany(mappedBy = "mainProduct")
    public List<ProductVariant> productDetail;

    public Product() {
        this.productDetail = new ArrayList<>();
    }

    public Product(List<ProductVariant> productDetail, String updatedAt, String createdAt, String productName, Integer id) {
        this.productDetail = productDetail;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.productName = productName;
        this.id = id;
    }

    public List<ProductVariant> getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(List<ProductVariant> productDetail) {
        this.productDetail = productDetail;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
