package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<OrderItem, Integer> {

}
