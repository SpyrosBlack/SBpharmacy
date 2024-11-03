package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepo extends JpaRepository<Medicine, Integer> {


}
