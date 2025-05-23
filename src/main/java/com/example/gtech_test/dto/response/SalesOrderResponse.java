package com.example.gtech_test.dto.response;

import com.example.gtech_test.model.SalesOrder;
import com.example.gtech_test.model.SalesOrderDetail;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.example.gtech_test.util.CommonFunction.getDateTime;

public class SalesOrderResponse implements ResultSetExtractor<List<SalesOrder>> {

    @Override
    public List<SalesOrder> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, SalesOrder> orderMap = new LinkedHashMap<>();

        while (rs.next()) {
            int orderId = rs.getInt("sales_order_id");

            SalesOrder order = orderMap.get(orderId);
            if (order == null) {
                order = new SalesOrder();
                order.setId(orderId);
                order.setEmailCustomer(rs.getString("email_customer"));
                order.setOrderNumber(rs.getString("order_number"));
                order.setSubtotal(rs.getDouble("sales_order_subtotal"));
                order.setTotal(rs.getDouble("sales_order_total"));
                order.setShippingFee(rs.getDouble("shipping_fee"));
                order.setCreatedAt(getDateTime(rs.getTimestamp("sales_order_created_at")));
                order.setUpdatedAt(getDateTime(rs.getTimestamp("sales_order_updated_at")));

                orderMap.put(orderId, order);
            }

            int detailId = rs.getInt("detail_id");
            if (detailId > 0) {
                SalesOrderDetail detail = new SalesOrderDetail();
                detail.setId(detailId);
                detail.setSalesOrderId(rs.getInt("sales_order_id"));
                detail.setProductId(rs.getInt("product_id"));
                detail.setProductVariantId(rs.getInt("product_variant_id"));
                detail.setPrice(rs.getDouble("price"));
                detail.setMarginValue(rs.getDouble("margin_value"));
                detail.setQty(rs.getInt("qty"));
                detail.setSubtotal(rs.getDouble("detail_subtotal"));
                detail.setMarginPrice(rs.getDouble("margin_price"));
                detail.setTaxValue(rs.getDouble("tax_value"));
                detail.setTaxPrice(rs.getDouble("tax_price"));
                detail.setTotalPrice(rs.getDouble("total_price"));
                detail.setCreatedAt(getDateTime(rs.getTimestamp("detail_created_at")));
                detail.setUpdatedAt(getDateTime(rs.getTimestamp("detail_updated_at")));

                order.getSalesOrderDetails().add(detail);
            }
        }
        return new ArrayList<>(orderMap.values());
    }
}