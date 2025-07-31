package com.dw.jdbcapp.service;

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

    public Customer getCustomerById(String id) {
        //return customerJdbcRepository.getCustomerById(id);
        return customerTemplateRepository.getCustomerById(id);
    }

    public List<Customer> getAllCustomers() {
        return customerTemplateRepository.getAllCustomers();
    }

    public List<Customer> getCustomerWithHighMileThanAvg() {
        return customerTemplateRepository.getCustomerWithHighMileThanAvg();
    }

    public List<Customer> getCustomerByMileageGrade(
                            @PathVariable String grade) {
        return customerTemplateRepository.getCustomerByMileageGrade(grade);
    }
}