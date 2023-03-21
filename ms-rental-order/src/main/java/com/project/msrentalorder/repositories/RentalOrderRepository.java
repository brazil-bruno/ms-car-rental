package com.project.msrentalorder.repositories;

import com.project.msrentalorder.entities.RentalOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalOrderRepository extends JpaRepository<RentalOrder, Long> {
}
