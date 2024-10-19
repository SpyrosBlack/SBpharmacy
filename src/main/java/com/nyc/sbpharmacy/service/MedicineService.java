package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.repos.MedicineRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineService {
    private final MedicineRepo medicineRepo;

    public MedicineService(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    public List<Medicine> getAllMedicine(){
    return medicineRepo.findAll();
}
}
