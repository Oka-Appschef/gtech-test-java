package com.example.gtech_test.repository;

import com.example.gtech_test.dto.SalesOrderReportDto;
import com.example.gtech_test.dto.response.SalesOrderReportResponse;
import com.example.gtech_test.dto.response.SalesOrderResponse;
import com.example.gtech_test.model.SalesOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesOrderRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public SalesOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SalesOrder> findAll(){
        String sql = "SELECT" +
                "    so.id AS sales_order_id," +
                "    so.email_customer," +
                "    so.order_number," +
                "    so.subtotal AS sales_order_subtotal," +
                "    so.total AS sales_order_total," +
                "    so.shipping_fee," +
                "    so.created_at AS sales_order_created_at," +
                "    so.updated_at AS sales_order_updated_at," +
                "    sod.id AS detail_id," +
                "    sod.transaction_id," +
                "    sod.product_id," +
                "    sod.product_variant_id," +
                "    sod.price," +
                "    sod.margin_value," +
                "    sod.qty," +
                "    sod.subtotal AS detail_subtotal," +
                "    sod.margin_price," +
                "    sod.tax_value," +
                "    sod.tax_price," +
                "    sod.total_price," +
                "    sod.created_at AS detail_created_at," +
                "    sod.updated_at AS detail_updated_at " +
                " FROM sales_order so " +
                " LEFT JOIN sales_order_detail sod ON sod.transaction_id = so.id " +
                " ORDER BY so.id, sod.id;";
        return jdbcTemplate.query(sql,new SalesOrderResponse());
    }

    public List<SalesOrderReportDto> findSalesOrderPeriod(String startMonth, String endMonth){
        String sql = "SELECT  " +
                "    ROW_NUMBER() OVER (ORDER BY pv.id) AS row_number, " +
                "    p.id AS product_id, " +
                "    p.product_name as product_name, " +
                "    pv.variant_name AS product_variant_name, " +
                "    SUM(sod.total_price) AS total_sales_income, " +
                "    SUM(sod.margin_price) AS total_margin " +
                "FROM  " +
                "    sales_order_detail sod " +
                "JOIN " +
                "    sales_order so ON sod.transaction_id = so.id " +
                "JOIN  " +
                "    product_variant pv ON sod.product_variant_id = pv.id " +
                "JOIN  " +
                "    product p ON pv.product_id = p.id " +
                "WHERE " +
                "    so.created_at BETWEEN '"+ startMonth +"' AND '"+ endMonth +"' " +
                "GROUP BY  " +
                "    p.id, p.product_name, pv.id, pv.variant_name " +
                "ORDER BY  " +
                "    pv.id;";
        return jdbcTemplate.query(sql,new SalesOrderReportResponse());
    }
}
