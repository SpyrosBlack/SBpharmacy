package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.controllers.MainController;
import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.Pharmacist;
import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.repos.AppUserRepo;
import com.nyc.sbpharmacy.repos.PharmacistRepo;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private AppUserRepo appUserRepo;

    private PharmacistRepo pharmacistRepo;

    public AppUserService(AppUserRepo appUserRepo, PharmacistRepo pharmacistRepo) {
        this.appUserRepo = appUserRepo;
        this.pharmacistRepo = pharmacistRepo;
    }

    public AppUserDto dologin(String username, String password) {
        AppUser u =  appUserRepo.findByUsernameAndUserpassword(username, password);
        if(u!=null) {
            return mapToDto(u);
        }else
            return null;

    }

    public Pharmacist getPharmacyForUser(AppUserDto user){
           return pharmacistRepo.findByUser(mapToEntity(user));
    }

    public AppUserDto mapToDto(AppUser entity){
        AppUserDto dto = new AppUserDto();
        dto.setUsername(entity.getUsername());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setRole(entity.getRole());
        return dto;
    }

    public AppUser mapToEntity(AppUserDto dto){
        return appUserRepo.findById(dto.getUsername()).get();
    }
}
