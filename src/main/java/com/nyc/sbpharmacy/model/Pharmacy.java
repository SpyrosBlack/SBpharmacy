package com.nyc.sbpharmacy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pharmacyid;
    private String pharmacyname;
    private String pharmacyaddress;
    private String pharmacycity;

    public Pharmacy() {
    }

    public Pharmacy(Integer pharmacyId) {
        this.pharmacyid = pharmacyId;
    }

    public Integer getPharmacyId() {
        return pharmacyid;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyid = pharmacyId;
    }

    public String getPharmacyname() {
        return pharmacyname;
    }

    public void setPharmacyname(String pharmacyName) {
        this.pharmacyname = pharmacyName;
    }

    public String getPharmacyaddress() {
        return pharmacyaddress;
    }

    public void setPharmacyaddress(String pharmacyAddress) {
        this.pharmacyaddress = pharmacyAddress;
    }

    public String getPharmacycity() {
        return pharmacycity;
    }

    public void setPharmacycity(String pharmacyCity) {
        this.pharmacycity = pharmacyCity;
    }
}
