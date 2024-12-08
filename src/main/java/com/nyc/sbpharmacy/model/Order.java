package com.nyc.sbpharmacy.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pharmaorder")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyid")
    private Pharmacy pharmacy;

    @Temporal(TemporalType.DATE)
    private LocalDate orderdate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<OrderItem> items;

    public Order() {
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long id) {
        this.orderid = id;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public LocalDate getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(LocalDate orderdate) {
        this.orderdate = orderdate;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
