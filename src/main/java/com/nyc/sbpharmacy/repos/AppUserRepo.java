package com.nyc.sbpharmacy.repos;

import com.nyc.sbpharmacy.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepo extends JpaRepository<AppUser, String> {

    AppUser findByUsernameAndUserpassword(String username, String userpassword);
}
