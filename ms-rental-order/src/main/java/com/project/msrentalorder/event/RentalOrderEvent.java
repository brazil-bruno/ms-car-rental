package com.project.msrentalorder.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalOrderEvent {

    private String rentalOrderCode;
}
