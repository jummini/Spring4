package com.dw.jdbcapp.service;

import com.dw.jdbcapp.model.Customer;
import com.dw.jdbcapp.repository.CustomerJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    CustomerJdbcRepository customerJdbcRepository;

    public Customer getCustomerById(String id) {
        return customerJdbcRepository.getCustomerById(id);
    }
}
