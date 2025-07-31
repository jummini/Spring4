package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Customer;
import com.dw.jdbcapp.service.CustomerService;
import com.dw.jdbcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired // 의존성주입 (DI = Dependency Injection)
    CustomerService customerService;

    // GET 요청 (고객 한명의 정보 조회)
    // URL: GET /api/customer?id=123
    @GetMapping
    public Customer getCustomerById(@RequestParam String id) {
        return customerService.getCustomerById(id);
    }
}
