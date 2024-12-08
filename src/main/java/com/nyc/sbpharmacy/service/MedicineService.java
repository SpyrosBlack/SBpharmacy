package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.repos.MedicineRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineService {
    private final MedicineRepo medicineRepo;

    public MedicineService(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    public List<Medicine> getAllMedicine() {
        return medicineRepo.findAll()
                .stream().filter(m -> m.isDisabled() == false).collect(Collectors.toList());
    }

    public Medicine getMedicineById(int id) {
        return medicineRepo.getReferenceById(id);
    }

    public void insertMedicine(Medicine medicine) {
        medicineRepo.save(medicine);
    }

    public void updateMedicine(Medicine medicine) {
        medicineRepo.save(medicine);
    }

    public void disableMedicineById(Integer medicineid) {
        Medicine m = medicineRepo.getReferenceById(medicineid);
        m.setDisabled(true);
        medicineRepo.save(m);
    }
}
