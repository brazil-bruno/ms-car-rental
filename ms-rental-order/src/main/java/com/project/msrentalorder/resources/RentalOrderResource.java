package com.project.msrentalorder.resources;

import com.project.msrentalorder.entities.RentalOrder;
import com.project.msrentalorder.services.RentalOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalOrderResource {

    private final RentalOrderService rentalOrderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<RentalOrder> findAllRentalsOrders() {
        return rentalOrderService.findAllRentalsOrders();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public RentalOrder findRentalOrderById(@PathVariable Long id) {
        return  rentalOrderService.findRentalOrderById(id);
    }

    @PostMapping("/customerId/{customerId}/carId/{carId}")
    @ResponseStatus(HttpStatus.CREATED)
    public RentalOrder createNewRentalOrder(@PathVariable Long customerId, @PathVariable Long carId, @RequestBody RentalOrder rentalOrderRequest) {
        return rentalOrderService.createNewRentalOrder(customerId, carId, rentalOrderRequest);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRentalOrder(@PathVariable Long id) {
        rentalOrderService.deleteRentalOrderById(id);
    }

}
