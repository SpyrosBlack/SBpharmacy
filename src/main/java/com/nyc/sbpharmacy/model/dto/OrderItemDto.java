package com.nyc.sbpharmacy.model.dto;

import com.nyc.sbpharmacy.model.Medicine;

import java.util.Objects;


public class OrderItemDto {
    private Medicine medicine;

    private Integer quantity;

    public OrderItemDto() {
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

    @Override
    public String toString() {
        return "OrderItemDto{" +
                "medicine=" + medicine +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemDto that = (OrderItemDto) o;
        return Objects.equals(medicine, that.medicine);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(medicine);
    }
}
