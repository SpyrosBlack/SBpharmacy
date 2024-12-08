package com.nyc.sbpharmacy.model;

import jakarta.persistence.*;

@Entity
public class Pharmacy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pharmacyid;
    private String pharmacyname;
    private String pharmacyaddress;
    private String pharmacycity;
    private Float lat;
    private Float lng;
    @OneToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private AppUser appuser;

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

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public AppUser getUser() {
        return appuser;
    }

    public void setUser(AppUser user) {
        this.appuser = user;
    }
}
