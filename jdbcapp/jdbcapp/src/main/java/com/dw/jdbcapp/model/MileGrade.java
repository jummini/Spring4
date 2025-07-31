package com.dw.jdbcapp.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MileGrade {
    private String gradeName;
    private int lowerMileage;
    private int upperMileage;
}
