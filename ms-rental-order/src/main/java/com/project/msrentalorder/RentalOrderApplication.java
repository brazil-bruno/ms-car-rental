package com.project.msrentalorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RentalOrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(RentalOrderApplication.class, args);
    }
}