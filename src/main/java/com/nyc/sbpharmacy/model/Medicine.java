package com.nyc.sbpharmacy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer medicineid;

    String medicinename;
    float medicineprice;

    public Medicine() {
    }

    public Integer getMedicineid() {
        return medicineid;
    }

    public void setMedicineid(Integer medicineid) {
        this.medicineid = medicineid;
    }

    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicineName) {
        this.medicinename = medicineName;
    }

    public float getMedicineprice() {
        return medicineprice;
    }

    public void setMedicineprice(float medicinePrice) {
        this.medicineprice = medicinePrice;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineid=" + medicineid +
                ", medicinename='" + medicinename + '\'' +
                ", medicineprice=" + medicineprice +
                '}';
    }
}
