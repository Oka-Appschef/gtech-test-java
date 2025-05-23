package com.example.gtech_test.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.List;

@Table(name="sales_order")
public class SalesOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email_customer")
    private String emailCustomer;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "shipping_fee")
    private Double shippingFee;

    @Column(name = "total")
    private Double total;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "updated_at")
    private String updatedAt;

    @OneToMany(mappedBy = "salesOrderDetail")
    public List<SalesOrderDetail> salesOrderDetails;

    public SalesOrder() {
        this.salesOrderDetails = new ArrayList<>();
    }

    public SalesOrder(List<SalesOrderDetail> salesOrderDetails, String updatedAt, String createdAt, Double shippingFee, Double total, Double subtotal, String orderNumber, String emailCustomer, Integer id) {
        this.salesOrderDetails = salesOrderDetails;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.shippingFee = shippingFee;
        this.total = total;
        this.subtotal = subtotal;
        this.orderNumber = orderNumber;
        this.emailCustomer = emailCustomer;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Double shippingFee) {
        this.shippingFee = shippingFee;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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

    public List<SalesOrderDetail> getSalesOrderDetails() {
        return salesOrderDetails;
    }

    public void setSalesOrderDetails(List<SalesOrderDetail> salesOrderDetails) {
        this.salesOrderDetails = salesOrderDetails;
    }
}
