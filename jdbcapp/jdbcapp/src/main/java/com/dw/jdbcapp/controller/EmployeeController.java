package com.dw.jdbcapp.controller;

import com.dw.jdbcapp.model.Employee;
import com.dw.jdbcapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    // GET 요청 (직원 한명의 정보 조회)
    // URL: GET /api/employee?id=123
    @GetMapping
    public Employee getEmployeeById(@RequestParam String id) {
        return employeeService.getEmployeeById(id);
    }

    // GET 요청 (부서번호와 직위를 기준으로 해당 부서에 근무하는
    // 특정 직위의 사원 정보를 조회)
    // URL: GET /api/employee/{departmentNumber}/{position}
    @GetMapping("/{departmentNumber}/{position}")
    public List<Employee> getEmployeesWithDepartmentAndPosition(
            @PathVariable String departmentNumber,
            @PathVariable String position) {
        return employeeService.getEmployeesWithDepartmentAndPosition(
                departmentNumber, position);
    }

    // GET 요청 (입사일을 매개변수로 해당 입사일 이후로 입사한 사원들을 조회)
    // URL: GET /api/employee/hiredate?date=2000-01-01
    @GetMapping("/hiredate")
    public List<Employee> getEmployeesByHiredate(
            @RequestParam String date) {
        return employeeService.getEmployeesByHiredate(date);
    }
}
