package com.nyc.sbpharmacy.model.dto;


import com.nyc.sbpharmacy.model.Pharmacy;

import java.util.Objects;

public class AppUserDto {

    private String username;
    private String firstname;
    private String lastname;
    private String role;
    private Pharmacy pharmacy;

    public AppUserDto() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AppUserDto that = (AppUserDto) o;
        return Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username);
    }
}
