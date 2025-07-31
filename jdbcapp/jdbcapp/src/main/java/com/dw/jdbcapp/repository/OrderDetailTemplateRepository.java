package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDetailTemplateRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<OrderDetail> orderDetailRowMapper
            = new RowMapper<OrderDetail>() {
        @Override
        public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(rs.getString("주문번호"));
            orderDetail.setProductId(rs.getInt("제품번호"));
            orderDetail.setUnitPrice(rs.getInt("단가"));
            orderDetail.setOrderQuantity(rs.getInt("주문수량"));
            orderDetail.setDiscountRate(rs.getInt("할인율"));
            return orderDetail;
        }
    };
}
