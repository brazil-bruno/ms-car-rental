package com.project.msrentalorder.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {

    private Long id;
    private String carModel;
    private String description;
    private Double price;
}
