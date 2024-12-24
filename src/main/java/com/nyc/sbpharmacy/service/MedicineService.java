package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.repos.MedicineRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicineService {
    private final MedicineRepo medicineRepo;

    public MedicineService(MedicineRepo medicineRepo) {
        this.medicineRepo = medicineRepo;
    }

    public List<Medicine> getAllNotDisabledMedicine() {
//        List<Medicine> allMedicines = medicineRepo.findAll();
//        List<Medicine> returnedList = new ArrayList<>();
//        for(Medicine m : allMedicines) {
//            if (!m.isDisabledMed()){
//                returnedList.add(m);
//            }
//        }

        return medicineRepo.findAll()
                .stream().filter(m -> m.isDisabledMed() == false).collect(Collectors.toList());
    }

    public Medicine getMedicineById(int id) {
        return medicineRepo.findById(id).get();
    }

    public void insertMedicine(Medicine medicine) {
        medicineRepo.save(medicine);
    }

    public void updateMedicine(Medicine medicine) {
        medicineRepo.save(medicine);
    }

    public void disableMedicineById(Integer medicineid) {
        Medicine m = medicineRepo.getReferenceById(medicineid);
        m.setDisabledMed(true);
        medicineRepo.save(m);
       // medicineRepo.delete(m);
    }
}
