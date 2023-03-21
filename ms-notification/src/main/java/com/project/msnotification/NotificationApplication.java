package com.project.msnotification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
@EnableEurekaClient
@SpringBootApplication
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @KafkaListener(topics = "notificationTopic")
    public void handleNotification(RentalOrderEvent rentalOrderEvent) {
        log.info("Received Notification for Rental - {}", rentalOrderEvent.getRentalOrderCode());
    }
}