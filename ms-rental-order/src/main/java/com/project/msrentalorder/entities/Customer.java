package com.project.msrentalorder.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private Long id;
    private String fullName;
    private Integer age;
    private String phoneNumber;
    private String address;
}
