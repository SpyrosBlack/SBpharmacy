package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
}
