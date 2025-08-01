package com.dw.jdbcapp.repository;

import com.dw.jdbcapp.model.MileGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MileGradeTemplateRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final RowMapper<MileGrade> mileGradeRowMapper
            = new RowMapper<MileGrade>() {
        @Override
        public MileGrade mapRow(ResultSet rs, int rowNum) throws SQLException {
            MileGrade mileGrade = new MileGrade();
            mileGrade.setGradeName(rs.getString("등급명"));
            mileGrade.setLowerMileage(rs.getInt("하한마일리지"));
            mileGrade.setUpperMileage(rs.getInt("상한마일리지"));
            return mileGrade;
        }
    };
}
