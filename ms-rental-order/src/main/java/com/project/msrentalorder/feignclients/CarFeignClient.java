package com.project.msrentalorder.feignclients;

import com.project.msrentalorder.entities.Car;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@FeignClient(name = "ms-car", path = "/cars")
public interface CarFeignClient {

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    Car findCarById(@PathVariable Long id);
}
