package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderTemplateRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Order> orderRowMapper
            = new RowMapper<Order>() {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setOrderId(rs.getString("주문번호"));
            order.setCustomerId(rs.getString("고객번호"));
            order.setEmployeeId(rs.getString("사원번호"));
            order.setOrderDate(LocalDate.parse(rs.getString("주문일")));
            order.setRequestDate(LocalDate.parse(rs.getString("요청일")));
            order.setShippingDate(LocalDate.parse(rs.getString("발송일")));
            return order;
        }
    };
}
