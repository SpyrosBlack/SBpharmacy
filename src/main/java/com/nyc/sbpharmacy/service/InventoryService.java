package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Inventory;
import com.nyc.sbpharmacy.model.Pharmacy;
import com.nyc.sbpharmacy.repos.InventoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {


    private final InventoryRepo inventoryRepo;

    public InventoryService(InventoryRepo inventoryRepo) {
        this.inventoryRepo = inventoryRepo;
    }

    public List<Inventory> getPharmacyInventory(Pharmacy pharmacy) {

        return inventoryRepo.findByPharmacyOrderByDateofcount(pharmacy);
    }
}
