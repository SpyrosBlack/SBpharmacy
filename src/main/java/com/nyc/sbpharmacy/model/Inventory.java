package com.nyc.sbpharmacy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventory_id;

    @ManyToOne
    @JoinColumn(name="pharmacyid")
    private Pharmacy pharmacy;

    @ManyToOne
    @JoinColumn(name="medicineid")
    private Medicine medicine;

    private Integer quantity;

    @Temporal(TemporalType.DATE)
    private LocalDate dateofcount;

    public Long getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(Long inventory_id) {
        this.inventory_id = inventory_id;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public LocalDate getDateofcount() {
        return dateofcount;
    }

    public void setDateofcount(LocalDate dateofcount) {
        this.dateofcount = dateofcount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
