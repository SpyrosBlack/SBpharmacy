package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Pharmacy;
import com.nyc.sbpharmacy.model.dto.PharmacyDTO;
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
        pharmacyDTO.setPharmacyAddress(pharmacy.getPharmacyaddress());
        pharmacyDTO.setPharmacyName(pharmacy.getPharmacyname());
        pharmacyDTO.setPharmacyCity(pharmacy.getPharmacycity());
        return pharmacyDTO;
    }

    public Pharmacy mapToEntity(PharmacyDTO pharmacyDTO) {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setPharmacyaddress(pharmacyDTO.getPharmacyAddress());
        pharmacy.setPharmacyname(pharmacyDTO.getPharmacyName());
        pharmacy.setPharmacycity(pharmacyDTO.getPharmacyCity());
        return pharmacy;
    }
}
