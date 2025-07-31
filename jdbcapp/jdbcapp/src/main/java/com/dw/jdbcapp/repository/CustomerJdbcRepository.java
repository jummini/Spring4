package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.Customer;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class CustomerJdbcRepository {
    // #1. 데이터베이스 연결 정보
    private static final String URL = "jdbc:mariadb://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    // #2. 정보를 조회하는 메서드 정의
    // 고객번호로 고객 정보 조회
    public Customer getCustomerById(String customerId){
        Customer customer = null;
        String query = "select * from 고객 where 고객번호 = ?";
        try (
                Connection connection = DriverManager.getConnection(
                        URL, USER, PASSWORD);
                PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, customerId);
            try (ResultSet resultSet = ps.executeQuery()){
                System.out.println("연결성공");
                // O-R 매핑 (Object - Relation)
                if (resultSet.next()) {
                    customer = new Customer();
                    customer.setCustomerId(resultSet.getString("고객번호"));
                    customer.setCompanyName(resultSet.getString("고객회사명"));
                    customer.setContactName(resultSet.getString("담당자명"));
                    customer.setContactTitle(resultSet.getString("담당자직위"));
                    customer.setAddress(resultSet.getString("주소"));
                    customer.setCity(resultSet.getString("도시"));
                    customer.setRegion(resultSet.getString("지역"));
                    customer.setPhone(resultSet.getString("전화번호"));
                    customer.setMileage(resultSet.getInt("마일리지"));
                }
            }
        }catch (SQLException e) {
            System.out.println("에러 발생");
        }
        return customer;
    }
}
