package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.Inventory;
import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InventoryRepo extends JpaRepository<Inventory, Integer> {

    public List<Inventory> findByPharmacyOrderByDateofcount(Pharmacy pharmacy);

    @Query("select  i.quantity from Inventory i where i.pharmacy = ?1 and i.medicine=?2" +
            " order by i.dateofcount limit 1")
    public int fetchInventoryByMedicineAnPharmacy(Pharmacy pharmacy, Medicine medicine);
}
