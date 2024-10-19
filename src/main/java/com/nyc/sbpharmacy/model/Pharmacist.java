package com.nyc.sbpharmacy.model;

import jakarta.persistence.*;

@Entity
public class Pharmacist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pharmacistid;
    @OneToOne
    private AppUser user;
    @OneToOne
    private Pharmacy pharmacy;

    public Pharmacist() {
    }

    public Integer getPharmacistid() {
        return pharmacistid;
    }

    public void setPharmacistid(Integer pharmacistid) {
        this.pharmacistid = pharmacistid;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
