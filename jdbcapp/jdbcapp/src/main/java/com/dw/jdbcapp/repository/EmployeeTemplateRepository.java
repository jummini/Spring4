package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

@Repository
public class EmployeeTemplateRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Employee> employeeRowMapper
            = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setEmployeeId(rs.getString("사원번호"));
            employee.setName(rs.getString("이름"));
            employee.setEnglishName(rs.getString("영문이름"));
            employee.setPosition(rs.getString("직위"));
            employee.setGender(rs.getString("성별"));
            employee.setBirthDate(LocalDate.parse(rs.getString("생일")));
            employee.setHireDate(LocalDate.parse(rs.getString("입사일")));
            employee.setAddress(rs.getString("주소"));
            employee.setCity(rs.getString("도시"));
            employee.setRegion(rs.getString("지역"));
            employee.setHomePhone(rs.getString("집전화"));
            employee.setSupervisorId(rs.getString("상사번호"));
            employee.setDepartmentId(rs.getString("부서번호"));
            return employee;
        }
    };

    public Employee getEmployeeById(String id) {
        String query = "select * from 사원 where 사원번호 = ?";
        return jdbcTemplate.queryForObject(query, employeeRowMapper, id);
    }

    public List<Employee> getEmployeesWithDepartmentAndPosition(
            String departmentNumber, String position) {
        String query = "select * from 사원 where 부서번호 = ? and 직위 = ?";
        return jdbcTemplate.query(query, employeeRowMapper, departmentNumber, position);
    }

    public List<Employee> getEmployeesByHiredate(String date) {
        String query = "select * from 사원 where 입사일 >= ?";
        return jdbcTemplate.query(query, employeeRowMapper, date);
    }
}
