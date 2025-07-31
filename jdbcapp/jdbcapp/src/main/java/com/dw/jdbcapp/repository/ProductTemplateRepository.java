package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductTemplateRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Product> productRowMapper
            = new RowMapper<Product>() {
        @Override
        public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
            Product product = new Product();
            product.setProductId(rs.getInt("제품번호"));
            product.setProductName(rs.getString("제품명"));
            product.setPackageUnit(rs.getString("포장단위"));
            product.setUnitPrice(rs.getInt("단가"));
            product.setStock(rs.getInt("재고"));
            return product;
        }
    };
}
