package com.project.msrentalorder.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_rental_order")
public class RentalOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rentalOrderCode;
    private String customerName;
    private String phoneNumber;
    private String carModel;
    private String description;
    private Integer quantityOfDays;
    private Double totalPrice;
}
