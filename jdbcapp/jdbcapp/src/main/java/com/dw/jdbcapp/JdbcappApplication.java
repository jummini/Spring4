package com.dw.jdbcapp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.dw.jdbcapp.mapper")
public class JdbcappApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcappApplication.class, args);
	}

}
