package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepo extends JpaRepository<Pharmacist, Integer> {

    public Pharmacist findByUser(AppUser user);
}
