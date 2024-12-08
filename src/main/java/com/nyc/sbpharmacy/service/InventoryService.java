package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Inventory;
import com.nyc.sbpharmacy.model.InventoryWarehouse;
import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.model.Pharmacy;
import com.nyc.sbpharmacy.repos.InventoryRepo;
import com.nyc.sbpharmacy.repos.InventoryWarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {


    private final InventoryRepo inventoryRepo;
    private final InventoryWarehouseRepository inventoryWarehouseRepository;

    public InventoryService(InventoryRepo inventoryRepo, InventoryWarehouseRepository inventoryWarehouseRepository) {
        this.inventoryRepo = inventoryRepo;
        this.inventoryWarehouseRepository = inventoryWarehouseRepository;
    }

    public List<Inventory> getPharmacyInventory(Pharmacy pharmacy) {
        return inventoryRepo.findByPharmacyOrderByDateofcount(pharmacy);
    }

    public int fetchInventoryforMedicine(Pharmacy pharmacy, Medicine medicine) {
        return inventoryRepo.fetchInventoryByMedicineAnPharmacy(pharmacy, medicine);
    }

    public List<InventoryWarehouse> getInventoryWarehouses() {
        return inventoryWarehouseRepository.findAll();
    }
}
