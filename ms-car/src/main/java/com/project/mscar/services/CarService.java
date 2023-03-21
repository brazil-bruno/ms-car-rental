package com.project.mscar.services;

import com.project.mscar.entities.Car;
import com.project.mscar.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Transactional(readOnly = true)
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public Car newCar(Car carRequest) {
        Car car = Car.builder()
                .carModel(carRequest.getCarModel())
                .description(carRequest.getDescription())
                .price(carRequest.getPrice())
                .build();

        return carRepository.save(car);
    }

    @Transactional(readOnly = true)
    public Car findCarById(Long id) {
        Car car = carRepository.findById(id).get();
        return car;
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    @Transactional
    public Car updateCar(Long id, Car object) {
        Car entity = carRepository.findById(id).get();
        copyObjectToEntity(object, entity);
        return carRepository.save(entity);
    }

    private void copyObjectToEntity(Car object, Car entity) {
        entity.setCarModel(object.getCarModel());
        entity.setDescription(object.getDescription());
        entity.setPrice(object.getPrice());
    }
}
