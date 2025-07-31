package com.dw.jdbcapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Customer {
    private String customerId; // 고객번호
    private String companyName; // 고객회사명
    private String contactName; // 담당자명
    private String contactTitle; // 담당자직위
    private String address; // 주소
    private String city; // 도시
    private String region; // 지역
    private String phone; // 전화번호
    private int mileage; // 마일리지
}
