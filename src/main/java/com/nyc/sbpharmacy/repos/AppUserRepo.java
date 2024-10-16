package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
}
