package com.dw.jdbcapp.mapper;

import com.dw.jdbcapp.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface CustomerMapper {
    // 인터페이스에서는 접근지정자를 안쓰는것이 권장사항(간단명료)
    // 자동으로 public abstract가 추가됨
    // 매개변수의 타입을 xml파일에서 매핑할때 알 수 있도록 @Param(" ")형식을 쓰자!!
    Customer getCustomerById(@Param("id") String id);
    List<Customer> getAllCustomers();
    List<Customer> getCustomerWithHighMileThanAvg();
    List<Customer> getCustomerByMileageGrade(
            @Param("grade") String grade);
}
