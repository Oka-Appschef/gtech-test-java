package com.example.gtech_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder implements CommandLineRunner {

//    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DatabaseSeeder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void generateData() {
        initTable();
        insertSeeds();
    }

    public void initTable() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS Product");
        jdbcTemplate.execute("DROP TABLE IF EXISTS Product_Variant");
        jdbcTemplate.execute("DROP TABLE IF EXISTS sales_order");
        jdbcTemplate.execute("DROP TABLE IF EXISTS sales_order_detail");
        jdbcTemplate.execute("CREATE TABLE Product(id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, product_name VARCHAR(255), created_at DATETIME, updated_at DATETIME)");
        jdbcTemplate.execute("CREATE TABLE Product_Variant ( id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, product_id INT NOT NULL, variant_name VARCHAR(255), price DOUBLE, stock INT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, FOREIGN KEY (product_id) REFERENCES Product(id))");
        jdbcTemplate.execute("CREATE TABLE sales_order (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, email_customer VARCHAR(255), order_number VARCHAR(255), subtotal DOUBLE, total DOUBLE, shipping_fee DOUBLE, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP)");
        jdbcTemplate.execute("CREATE TABLE sales_order_detail (id INT PRIMARY KEY NOT NULL AUTO_INCREMENT, sales_order_id INT NOT NULL, product_id INT, product_variant_id INT, price DOUBLE, margin_value DOUBLE, qty INT, subtotal DOUBLE, margin_price DOUBLE, tax_value DOUBLE, tax_price DOUBLE, total_price DOUBLE, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, FOREIGN KEY (product_id) REFERENCES Product(id), FOREIGN KEY (product_variant_id) REFERENCES product_variant(id))");
    }

    public void insertSeeds() {
        jdbcTemplate.execute("INSERT INTO Product(product_name, created_at, updated_at) " +
                "VALUES('Asus', '2023-05-14 00:00:00', '2023-05-14 00:00:00')");
        jdbcTemplate.execute("INSERT INTO Product(product_name, created_at, updated_at) " +
                "VALUES('Lenovo', '2023-05-14 00:00:00', '2023-05-14 00:00:00')");
        jdbcTemplate.execute("INSERT INTO Product(product_name, created_at, updated_at) " +
                "VALUES('HP', '2023-05-14 00:00:00', '2023-05-14 00:00:00')");
        jdbcTemplate.execute("INSERT INTO Product(product_name, created_at, updated_at) " +
                "VALUES('MSI', '2023-05-14 00:00:00', '2023-05-14 00:00:00')");
        jdbcTemplate.execute("INSERT INTO Product(product_name, created_at, updated_at) " +
                "VALUES('MacBook', '2023-05-14 00:00:00', '2023-05-14 00:00:00')");

        jdbcTemplate.execute("INSERT INTO Product_Variant (product_id, variant_name, price, stock)" +
                "VALUES (1, 'TUF', 250000, 50)");
        jdbcTemplate.execute("INSERT INTO Product_Variant (product_id, variant_name, price, stock)" +
                "VALUES (1, 'ROG', 350000, 50)");
        jdbcTemplate.execute("INSERT INTO Product_Variant (product_id, variant_name, price, stock)" +
                "VALUES (1, 'Zentab', 450000, 50)");
        jdbcTemplate.execute("INSERT INTO Product_Variant (product_id, variant_name, price, stock)" +
                "VALUES (1, 'Vivobook', 500000, 50)");

        jdbcTemplate.execute("INSERT INTO Product_Variant (product_id, variant_name, price, stock)" +
                "VALUES (2, 'Legion', 500000, 50)");
        jdbcTemplate.execute("INSERT INTO Product_Variant (product_id, variant_name, price, stock)" +
                "VALUES (2, 'Thinkpad', 150000, 50)");

        jdbcTemplate.execute("INSERT INTO sales_order (email_customer, order_number, subtotal, shipping_fee, total, created_at, updated_at)" +
                "VALUES ('agus@gmail.com', 'INV001', 625000, 10000, 63500, '2025-01-15 10:00:00', '2025-01-15 10:00:00'), " +
                "('budi@gmail.com', 'INV002', 187500, 10000, 197500, '2025-01-15 10:00:00', '2025-01-15 10:00:00'), " +
                "('siti@gmail.com', 'INV003', 1500000, 10000, 1697500, '2025-03-08 14:30:00', '2025-03-08 14:30:00'), " +
                "('andi@example.com', 'INV004', 1000000, 10000, 1010000, '2025-03-15 10:00:00', '2025-03-15 10:00:00'), " +
                "('budi@example.com', 'INV005', 650000, 10000, 660000, '2025-05-02 09:15:00', '2025-05-02 09:15:00'), " +
                "('citra@example.com', 'INV006', 800000, 10000, 810000, '2025-05-02 09:15:00', '2025-05-02 09:15:00')" +
                ";");

        jdbcTemplate.execute("INSERT INTO sales_order_detail (sales_order_id, product_id, product_variant_id, price, margin_value, qty,subtotal, margin_price, tax_value, tax_price, total_price, created_at, updated_at)" +
                "VALUES (1, 1, 1, 250000, 0.15, 2, 500000, 75000, 0.10, 50000, 625000, '2025-01-15 10:00:00', '2025-01-15 10:00:00')");
        jdbcTemplate.execute("INSERT INTO sales_order_detail (sales_order_id, product_id, product_variant_id, price, margin_value, qty,subtotal, margin_price, tax_value, tax_price, total_price, created_at, updated_at)" +
                "VALUES (2, 2, 6, 150000, 0.15, 1, 150000, 22500, 0.10, 15000, 187500, '2025-01-15 10:00:00', '2025-01-15 10:00:00')");
        jdbcTemplate.execute("INSERT INTO sales_order_detail (sales_order_id, product_id, product_variant_id, price, margin_value, qty,subtotal, margin_price, tax_value, tax_price, total_price, created_at, updated_at)" +
                "VALUES (3, 1, 2, 350000, 0.15, 1, 350000, 52500, 0.10, 35000, 437500, '2025-03-08 14:30:00', '2025-03-08 14:30:00'),(3, 2, 5, 500000, 0.15, 2, 1000000, 150000, 0.10, 100000, 1250000, '2025-03-08 14:30:00', '2025-03-08 14:30:00')");
        jdbcTemplate.execute("INSERT INTO sales_order_detail (sales_order_id, product_id, product_variant_id, price, margin_value, qty,subtotal, margin_price, tax_value, tax_price, total_price, created_at, updated_at)" +
                "VALUES (4, 1, 1, 250000, 0.15, 2, 500000, 75000, 0.10, 50000, 625000, '2025-03-08 14:30:00', '2025-03-08 14:30:00'),(4, 1, 2, 350000, 0.15, 1, 350000, 52500, 0.10, 35000, 437500, '2025-03-08 14:30:00', '2025-03-08 14:30:00')");
        jdbcTemplate.execute("INSERT INTO sales_order_detail (sales_order_id, product_id, product_variant_id, price, margin_value, qty,subtotal, margin_price, tax_value, tax_price, total_price, created_at, updated_at)" +
                "VALUES (5, 2, 6, 150000, 0.15, 2, 300000, 45000, 0.10, 30000, 375000, '2025-03-08 14:30:00', '2025-03-08 14:30:00'),(5, 2, 5, 500000, 0.15, 1, 500000, 75000, 0.10, 50000, 625000, '2025-03-08 14:30:00', '2025-03-08 14:30:00')");
        jdbcTemplate.execute("INSERT INTO sales_order_detail (sales_order_id, product_id, product_variant_id, price, margin_value, qty,subtotal, margin_price, tax_value, tax_price, total_price, created_at, updated_at)" +
                "VALUES (6, 1, 3, 450000, 0.15, 1, 450000, 67500, 0.10, 45000, 562500, '2025-03-08 14:30:00', '2025-03-08 14:30:00'),(6, 1, 1, 250000, 0.15, 1, 250000, 37500, 0.10, 25000, 312500, '2025-03-08 14:30:00', '2025-03-08 14:30:00')");

    }

    @Override
    public void run(String... args) throws Exception {
        generateData();
    }
}

