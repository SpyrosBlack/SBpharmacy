package com.nyc.sbpharmacy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pharmacyId;

    private String pharmacyName;
    private String pharmacyAddress;
    private String pharmacyCity;

    public Pharmacy() {
    }

    public Pharmacy(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

//    public void setPharmacyId(Integer pharmacyId) {
//        this.pharmacyId = pharmacyId;
//    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public String getPharmacyCity() {
        return pharmacyCity;
    }

    public void setPharmacyCity(String pharmacyCity) {
        this.pharmacyCity = pharmacyCity;
    }
}
