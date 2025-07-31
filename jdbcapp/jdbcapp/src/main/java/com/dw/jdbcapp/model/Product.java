package com.dw.jdbcapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Product {
    private int productId;
    private String productName;
    private String packageUnit;
    private double unitPrice;
    private int stock;
}
