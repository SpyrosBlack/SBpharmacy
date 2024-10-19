package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {

}
