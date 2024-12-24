package com.nyc.sbpharmacy.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.ColumnDefault;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Medicine {

    String medicinename;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicineid;

    @Positive(message = "Price muct be a positive number")
    private float medicineprice;

    @OneToMany(mappedBy = "medicine", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OrderItem> orderItemSet = new HashSet<>();

    @ColumnDefault("false")
    private boolean disabledMed;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category")
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


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


    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }


    public float getMedicineprice() {
        return medicineprice;
    }


    public void setMedicineprice(float medicineprice) {
        this.medicineprice = medicineprice;
    }


    public Set<OrderItem> getOrderItemSet() {
        return orderItemSet;
    }


    public void setOrderItemSet(Set<OrderItem> orderItemSet) {
        this.orderItemSet = orderItemSet;
    }


    public boolean isDisabledMed() {
        return disabledMed;
    }


    public void setDisabledMed(boolean isdisabled) {
        this.disabledMed = isdisabled;
    }


    @Override
    public String toString() {
        return "Medicine{" +
                "medicineid=" + medicineid +
                ", medicinename='" + medicinename + '\'' +
                ", medicineprice=" + medicineprice +
                ", orderItemSet=" + orderItemSet +
                ", isdisabled=" + disabledMed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(medicineid, medicine.medicineid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(medicineid);
    }


}
