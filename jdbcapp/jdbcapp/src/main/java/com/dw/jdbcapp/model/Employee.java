package com.dw.jdbcapp.model;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Employee {
    private String employeeId;
    private String name;
    private String englishName;
    private String position;
    private String gender;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private String address;
    private String city;
    private String region;
    private String homePhone;
    private String supervisorId;
    private String departmentId;
}
