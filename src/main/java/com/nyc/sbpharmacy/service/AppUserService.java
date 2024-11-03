package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.repos.AppUserRepo;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    private AppUserRepo appUserRepo;



    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public AppUserDto dologin(String username, String password) {
        AppUser u =  appUserRepo.findByUsernameAndUserpassword(username, password);
        if(u!=null) {
            return mapToDto(u);
        }else
            return null;

    }

    public AppUserDto mapToDto(AppUser entity){
        AppUserDto dto = new AppUserDto();
        dto.setUsername(entity.getUsername());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        dto.setRole(entity.getRole().name());
        return dto;
    }

    public AppUser mapToEntity(AppUserDto dto){
        return appUserRepo.findById(dto.getUsername()).get();
    }
}
