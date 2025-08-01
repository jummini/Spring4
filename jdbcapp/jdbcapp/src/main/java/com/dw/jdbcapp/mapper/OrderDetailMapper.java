package com.dw.jdbcapp.mapper;

import com.dw.jdbcapp.model.OrderDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailMapper {
    List<OrderDetail> getAllOrderDetails();
}
