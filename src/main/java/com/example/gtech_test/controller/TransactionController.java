package com.example.gtech_test.controller;

import com.example.gtech_test.dto.SalesOrderReportDto;
import com.example.gtech_test.dto.request.SalesOrderRequest;
import com.example.gtech_test.model.SalesOrder;
import com.example.gtech_test.service.SalesOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class TransactionController {

    private SalesOrderService salesOrderService;

    @Autowired
    public TransactionController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    @GetMapping("transaction/list")
    public ResponseEntity<String> listAllProducts() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<SalesOrder> salesOrders = salesOrderService.getAllSalesOrder();
        return ResponseEntity.status(HttpStatus.OK).body(mapper.writeValueAsString(salesOrders));
    }

    @GetMapping("transaction/sales-report")
    public ResponseEntity<String> listSalesReport(@RequestBody SalesOrderRequest request) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        List<SalesOrderReportDto> salesOrderReportDtoList = salesOrderService.getSalesOrderReport(request.getStartMonth(), request.getEndMonth());
        return ResponseEntity.status(HttpStatus.OK).body(mapper.writeValueAsString(salesOrderReportDtoList));
    }


}
