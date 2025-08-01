package com.dw.jdbcapp.service;

import com.dw.jdbcapp.mapper.EmployeeMapper;
import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.repository.EmployeeTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee getEmployeeById(String id) {
        return employeeMapper.getEmployeeById(id);
    }

    public List<Employee> getEmployeesWithDepartmentAndPosition(
            String departmentNumber, String position) {
        return employeeMapper.getEmployeesWithDepartmentAndPosition(
                departmentNumber, position);
    }

    public List<Employee> getEmployeesByHiredate(String date) {
        return employeeMapper.getEmployeesByHiredate(date);
    }
}
