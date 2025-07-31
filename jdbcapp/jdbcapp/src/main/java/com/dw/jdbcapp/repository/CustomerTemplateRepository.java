package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CustomerTemplateRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    // RowMapper는 인터페이스이므로 생성자가 없음.
    // 상속한 자식클래스의 생성자를 사용해야하나 자식클래스를 만들지 않고도
    // 메서드 오버라이드를 하는 조건으로 인터페이스의 객체 생성을 할 수 있음
    // ==> 익명 이너 클래스
    private final RowMapper<Customer> customerRowMapper
            = new RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setCustomerId(rs.getString("고객번호"));
            customer.setCompanyName(rs.getString("고객회사명"));
            customer.setContactName(rs.getString("담당자명"));
            customer.setContactTitle(rs.getString("담당자직위"));
            customer.setAddress(rs.getString("주소"));
            customer.setCity(rs.getString("도시"));
            customer.setRegion(rs.getString("지역"));
            customer.setPhone(rs.getString("전화번호"));
            customer.setMileage(rs.getInt("마일리지"));
            return customer;
        }
    };

    public Customer getCustomerById(String id) {
        String query = "select * from 고객 where 고객번호 = ?";
        // queryForObject는 DB로부터의 응답이 한개일때
        // query는 여러개일때 사용하며 List<Customer>형태로 만들어짐
        return jdbcTemplate.queryForObject(query, customerRowMapper, id);
    }

    public List<Customer> getAllCustomers() {
        String query = "select * from 고객";
        return jdbcTemplate.query(query, customerRowMapper);
    }

    public List<Customer> getCustomerWithHighMileThanAvg() {
        String query = "select * from 고객 where 마일리지 > " +
                "(select avg(마일리지) from 고객)";
        return jdbcTemplate.query(query, customerRowMapper);
    }

    public List<Customer> getCustomerByMileageGrade(
                            @PathVariable String grade) {
        String query = "select 고객.* from 고객 join 마일리지등급 " +
                "on 고객.마일리지 between 마일리지등급.하한마일리지 and 마일리지등급.상한마일리지\n" +
                "where 마일리지등급.등급명 = ?";
        return jdbcTemplate.query(query, customerRowMapper, grade);
    }
}
