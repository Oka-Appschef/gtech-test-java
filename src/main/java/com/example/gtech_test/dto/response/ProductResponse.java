package com.example.gtech_test.dto.response;

import com.example.gtech_test.model.Product;
import com.example.gtech_test.model.ProductVariant;
import com.example.gtech_test.util.CommonFunction;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ProductResponse implements ResultSetExtractor<List<Product>> {

    @Override
    public List<Product> extractData(ResultSet rs) throws SQLException, DataAccessException {
        Map<Integer, Product> productMap = new LinkedHashMap<>();
        while(rs.next()) {
            int productId = rs.getInt("product_id");
            Product product = productMap.get(productId);
            if (product == null){
                product = new Product();
                product.setId(rs.getInt("id"));
                product.setProductName(rs.getString("product_name"));
                product.setCreatedAt(CommonFunction.getDateTime(rs.getTimestamp("created_at")));
                product.setUpdatedAt(CommonFunction.getDateTime(rs.getTimestamp("updated_at")));
                productMap.put(product.getId(), product);
            }

            ProductVariant productVariant = new ProductVariant();
            productVariant.setId(rs.getInt("variant_id"));
            productVariant.setVariantName(rs.getString("variant_name"));
            productVariant.setPrice(rs.getDouble("price"));
            productVariant.setStock(rs.getInt("stock"));
            productVariant.setCreatedAt(CommonFunction.getDateTime(rs.getTimestamp("variant_created_at")));
            productVariant.setUpdatedAt(CommonFunction.getDateTime(rs.getTimestamp("variant_updated_at")));
            product.getProductDetail().add(productVariant);
        }
        return new ArrayList<>(productMap.values());
    }
}
