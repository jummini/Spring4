package com.dw.jdbcapp.service;

import com.dw.jdbcapp.mapper.OrderDetailMapper;
import com.dw.jdbcapp.model.OrderDetail;
import com.dw.jdbcapp.repository.OrderDetailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailMapper orderDetailMapper;

    public List<OrderDetail> getAllOrderDetails() {
        return  orderDetailMapper.getAllOrderDetails();
    }
}
