package com.project.msrentalorder.feignclients;

import com.project.msrentalorder.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Component
@FeignClient(name = "ms-customer", path = "/customers")
public interface CustomerFeignClient {

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Customer findCustomerById(@PathVariable Long id);
}
