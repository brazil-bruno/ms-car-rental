package com.project.mscustomer.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tb_customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private Integer age;
    private String phoneNumber;
    private String address;
}
