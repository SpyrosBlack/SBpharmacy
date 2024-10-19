package com.nyc.sbpharmacy.model.dto;

import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.model.Pharmacy;
import jakarta.persistence.*;

import java.time.LocalDate;


public class OrderDto {

    private Integer orderid;
    private Pharmacy pharmacy;
    private Medicine medicine;
    private Integer quantity;
    private LocalDate orderdate;

    public OrderDto() {
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
