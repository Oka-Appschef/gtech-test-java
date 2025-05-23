package com.example.gtech_test.dto.response;

import com.example.gtech_test.dto.SalesOrderReportDto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalesOrderReportResponse implements ResultSetExtractor<List<SalesOrderReportDto>> {

    @Override
    public List<SalesOrderReportDto> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<SalesOrderReportDto> salesOrderReportDtoList = new ArrayList<>();
        while (rs.next()) {

            SalesOrderReportDto orderReportDto = new SalesOrderReportDto();
            orderReportDto.setNo(rs.getInt("row_number"));
            orderReportDto.setProductId(rs.getInt("product_id"));
            orderReportDto.setProductName(rs.getString("product_name"));
            orderReportDto.setProductVariant(rs.getString("product_variant_name"));
            orderReportDto.setSalesIncome(rs.getDouble("total_sales_income"));
            orderReportDto.setSalesMargin(rs.getDouble("total_margin"));
            salesOrderReportDtoList.add(orderReportDto);

        }
        return salesOrderReportDtoList;
    }
}