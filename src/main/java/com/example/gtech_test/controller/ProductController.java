package com.example.gtech_test.controller;

import com.example.gtech_test.dto.request.ProductRequest;
import com.example.gtech_test.model.Product;
import com.example.gtech_test.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("product/list")
    public ResponseEntity<String> listAllProducts() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Product> productRequest = productService.getAllProduct();
        return ResponseEntity.status(HttpStatus.OK).body(mapper.writeValueAsString(productRequest));
    }

}
