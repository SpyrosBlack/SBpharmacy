package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine, Integer> {


}
