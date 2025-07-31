package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Customer;
import com.dw.jdbcapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // GET 요청 (고객 전체의 정보 조회)
    // URL: GET /api/customer/all
    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    // GET 요청 (전체 평균마일리지보다 큰 마일리지를 가진 고객들을 조회)
    // URL: GET /api/customer/high-mile-than-avg
    @GetMapping("/high-mile-than-avg")
    public List<Customer> getCustomerWithHighMileThanAvg(){
        return customerService.getCustomerWithHighMileThanAvg();
    }

    // GET 요청 (마일리지등급을 매개변수로 해당 마일리지등급을 가진 고객들을 조회)
    // URL: GET /api/customer/grade/{grade}
    @GetMapping("/grade/{grade}")
    public List<Customer> getCustomerByMileageGrade(
                            @PathVariable String grade) {
        return customerService.getCustomerByMileageGrade(grade);
    }
}
