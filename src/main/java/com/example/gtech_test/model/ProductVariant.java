package com.example.gtech_test.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "Product_Variant")
public class ProductVariant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "variant_name")
    private String variantName;

    @Column(name = "price")
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;


    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public Product mainProduct;

    public ProductVariant() {
    }

    public ProductVariant(String updatedAt, Integer stock, Integer id, String variantName, Double price, String createdAt, Product mainProduct) {
        this.updatedAt = updatedAt;
        this.stock = stock;
        this.id = id;
        this.variantName = variantName;
        this.price = price;
        this.createdAt = createdAt;
        this.mainProduct = mainProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getMainProduct() {
        return mainProduct;
    }

    public void setMainProduct(Product mainProduct) {
        this.mainProduct = mainProduct;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }
}
