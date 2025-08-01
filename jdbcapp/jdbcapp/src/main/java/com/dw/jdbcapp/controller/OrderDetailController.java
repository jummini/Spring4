package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.OrderDetail;
import com.dw.jdbcapp.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orderdetail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;

    // GET 요청 (주문세부 전체 정보 조회)
    // URL: GET /api/orderdetail
    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailService.getAllOrderDetails();
    }

}
