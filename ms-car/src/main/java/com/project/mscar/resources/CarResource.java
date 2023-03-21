package com.project.mscar.resources;

import com.project.mscar.entities.Car;
import com.project.mscar.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarResource {

    private final CarService carService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Car> findAllCustomers() {
        return carService.findAllCars();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Car newCar(@RequestBody Car carRequest) {
        return carService.newCar(carRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car findCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Car updateCar(@PathVariable Long id, @RequestBody Car object) {
        return carService.updateCar(id, object);
    }
}
