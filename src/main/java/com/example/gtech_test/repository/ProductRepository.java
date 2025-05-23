package com.example.gtech_test.repository;

import com.example.gtech_test.dto.response.ProductResponse;
import com.example.gtech_test.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Product> findAll(){
        String sql = "SELECT p.id as product_id, p.product_name, pv.id AS variant_id," +
                "    pv.variant_name," +
                "    pv.price," +
                "    pv.stock, p.created_at AS product_created_at," +
                "    p.updated_at AS product_updated_at, pv.created_at AS variant_created_at," +
                "    pv.updated_at AS variant_updated_at from product p" +
                " join product_variant pv ON p.id = pv.product_id" +
                " order by p.id asc";
        return jdbcTemplate.query(sql,new ProductResponse());
    }
}
