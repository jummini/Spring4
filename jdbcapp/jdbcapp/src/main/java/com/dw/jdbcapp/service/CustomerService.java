package com.dw.jdbcapp.service;

import com.dw.jdbcapp.mapper.CustomerMapper;
import com.dw.jdbcapp.model.Customer;
import com.dw.jdbcapp.repository.CustomerJdbcRepository;
import com.dw.jdbcapp.repository.CustomerTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerJdbcRepository customerJdbcRepository;
    @Autowired
    CustomerTemplateRepository customerTemplateRepository;
    @Autowired
    CustomerMapper customerMapper;

    public Customer getCustomerById(String id) {
        //return customerJdbcRepository.getCustomerById(id);
        return customerMapper.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerMapper.getAllCustomers();
    }

    public List<Customer> getCustomerWithHighMileThanAvg() {
        return customerMapper.getCustomerWithHighMileThanAvg();
    }

    public List<Customer> getCustomerByMileageGrade(String grade) {
        return customerMapper.getCustomerByMileageGrade(grade);
    }
}