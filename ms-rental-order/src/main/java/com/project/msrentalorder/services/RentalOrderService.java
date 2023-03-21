package com.project.msrentalorder.services;

import com.project.msrentalorder.entities.Car;
import com.project.msrentalorder.entities.Customer;
import com.project.msrentalorder.entities.RentalOrder;
import com.project.msrentalorder.event.RentalOrderEvent;
import com.project.msrentalorder.feignclients.CarFeignClient;
import com.project.msrentalorder.feignclients.CustomerFeignClient;
import com.project.msrentalorder.repositories.RentalOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RentalOrderService {

    private final RentalOrderRepository rentalOrderRepository;

    private final CarFeignClient carFeignClient;

    private final CustomerFeignClient customerFeignClient;

    private final KafkaTemplate<String, RentalOrderEvent> kafkaTemplate;

    @Transactional(readOnly = true)
    public List<RentalOrder> findAllRentalsOrders() {
        return rentalOrderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public RentalOrder findRentalOrderById(Long id) {
        return rentalOrderRepository.findById(id).get();
    }

    @Transactional
    public RentalOrder createNewRentalOrder(Long customerId, Long carId, RentalOrder rentalOrderRequest) {

        Car car = carFeignClient.findCarById(carId);
        Customer customer = customerFeignClient.findCustomerById(customerId);

        RentalOrder rentalOrder = new RentalOrder();
        rentalOrder.setRentalOrderCode(UUID.randomUUID().toString());
        rentalOrder.setCustomerName(customer.getFullName());
        rentalOrder.setPhoneNumber(customer.getPhoneNumber());
        rentalOrder.setCarModel(car.getCarModel());
        rentalOrder.setDescription(car.getDescription());
        rentalOrder.setQuantityOfDays(rentalOrderRequest.getQuantityOfDays());
        rentalOrder.setTotalPrice(car.getPrice() * rentalOrderRequest.getQuantityOfDays());

        rentalOrderRepository.save(rentalOrder);

        kafkaTemplate.send("notificationTopic", new RentalOrderEvent("" + rentalOrder.getRentalOrderCode()));

        return rentalOrder;
    }

    public void deleteRentalOrderById(Long id) {
        rentalOrderRepository.deleteById(id);
    }

}
