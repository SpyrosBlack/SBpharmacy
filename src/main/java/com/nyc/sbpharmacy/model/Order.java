package com.nyc.sbpharmacy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "pharmaorders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderid;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name="pharmacyid")
    private Pharmacy pharmacy;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medicineid")
    private Medicine medicine;
    private Integer quantity;
    @Temporal(TemporalType.DATE)
    private LocalDate orderdate;

    public Order() {
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
