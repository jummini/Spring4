package com.dw.jdbcapp.mapper;

import com.dw.jdbcapp.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Employee getEmployeeById(@Param("id") String id);
    List<Employee> getEmployeesWithDepartmentAndPosition(
            @Param("departmentNumber") String departmentNumber,
            @Param("position") String position);
    List<Employee> getEmployeesByHiredate(@Param("date") String date);
}
