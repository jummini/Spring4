package com.dw.jdbcapp.service;

import com.dw.jdbcapp.model.OrderDetail;
import com.dw.jdbcapp.repository.OrderDetailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailTemplateRepository orderDetailTemplateRepository;

    public List<OrderDetail> getAllOrderDetails() {
        return  orderDetailTemplateRepository.getAllOrderDetails();
    }
}
