package com.example.gtech_test.service;

import com.example.gtech_test.dto.SalesOrderReportDto;
import com.example.gtech_test.model.SalesOrder;
import com.example.gtech_test.repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesOrderService {
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    public SalesOrderService(SalesOrderRepository salesOrderRepository) {
        this.salesOrderRepository = salesOrderRepository;
    }

    public List<SalesOrder> getAllSalesOrder(){
        return salesOrderRepository.findAll();
    }

    public List<SalesOrderReportDto> getSalesOrderReport(String startMonth, String endMonth){
        return salesOrderRepository.findSalesOrderPeriod(startMonth, endMonth);
    }
}
