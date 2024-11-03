package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.Inventory;
import com.nyc.sbpharmacy.model.Order;
import com.nyc.sbpharmacy.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    public List<Inventory> findByPharmacyOrderByDateofcount(Pharmacy pharmacy);
}
