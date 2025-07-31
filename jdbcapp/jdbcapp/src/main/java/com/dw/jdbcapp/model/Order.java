package com.dw.jdbcapp.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Order {
    private String orderId;
    private String customerId;
    private String employeeId;
    private LocalDate orderDate;
    private LocalDate requestDate;
    private LocalDate shippingDate;
}
