package com.dw.jdbcapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class OrderDetail {
    private String orderId;
    private int productId;
    private double unitPrice;
    private int orderQuantity;
    private double discountRate;
}
