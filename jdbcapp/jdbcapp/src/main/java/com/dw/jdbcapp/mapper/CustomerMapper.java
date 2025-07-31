package com.dw.jdbcapp.mapper;

import com.dw.jdbcapp.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerMapper {
    Customer getCustomerById(@Param("id") String id);
    List<Customer> getAllCustomers();
    List<Customer> getCustomerWithHighMileThanAvg();
    List<Customer> getCustomerByMileageGrade(@Param("grade") String grade);
}
