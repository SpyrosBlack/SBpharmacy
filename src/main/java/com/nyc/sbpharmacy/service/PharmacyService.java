package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Pharmacy;
import com.nyc.sbpharmacy.model.PharmacyDTO;
import com.nyc.sbpharmacy.repos.PharmacyRepo;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService {

private final PharmacyRepo pharmacyRepo;

    public PharmacyService(PharmacyRepo pharmacyRepo) {
        this.pharmacyRepo = pharmacyRepo;
    }

    public Integer create(final PharmacyDTO pharmacyDTO) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy=mapToEntity(pharmacyDTO);
        return pharmacyRepo.save(pharmacy).getPharmacyId();
    }

    public PharmacyDTO mapToDTO(Pharmacy pharmacy) {
        PharmacyDTO pharmacyDTO = new PharmacyDTO();
        pharmacyDTO.setPharmacyAddress(pharmacy.getPharmacyAddress());
        pharmacyDTO.setPharmacyName(pharmacy.getPharmacyName());
        pharmacyDTO.setPharmacyCity(pharmacy.getPharmacyCity());
        return pharmacyDTO;
    }

    public Pharmacy mapToEntity(PharmacyDTO pharmacyDTO) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setPharmacyAddress(pharmacyDTO.getPharmacyAddress());
        pharmacy.setPharmacyName(pharmacyDTO.getPharmacyName());
        pharmacy.setPharmacyCity(pharmacyDTO.getPharmacyCity());
        return pharmacy;
    }
}
