package com.nyc.sbpharmacy.model.dto;

import com.nyc.sbpharmacy.model.Role;
import jakarta.persistence.*;

@Entity
public class AppUserDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String username;
    private String firstname;
    private String lastname;
    @Enumerated(EnumType.STRING)
    private Role role;


    public AppUserDto() {
    }



    public Integer getUserId() {
        return userId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String pharmacyName) {
        this.username = pharmacyName;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
