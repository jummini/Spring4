package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class DepartmentTemplateRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<Department> departmentRowMapper
            = new RowMapper<Department>() {
        @Override
        public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
            Department department = new Department();
            department.setDepartmentId(rs.getString("부서번호"));
            department.setDepartmentName(rs.getString("부서명"));
            return department;
        }
    };
}
