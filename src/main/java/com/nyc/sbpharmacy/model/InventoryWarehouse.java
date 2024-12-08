package com.nyc.sbpharmacy.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inventory_warehouse")
public class InventoryWarehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private Long id;

    @Column(name = "dateofcount")
    private LocalDate dateofcount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicineid")
    private Medicine medicine;

    @Column(name = "quantity")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateofcount() {
        return dateofcount;
    }

    public void setDateofcount(LocalDate dateofcount) {
        this.dateofcount = dateofcount;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicineid) {
        this.medicine = medicineid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}