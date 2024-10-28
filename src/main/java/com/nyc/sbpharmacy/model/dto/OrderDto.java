package com.nyc.sbpharmacy.model.dto;

import com.nyc.sbpharmacy.model.OrderItem;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderDto {

    private List<OrderItemDto> itemsofanorder = new ArrayList<>();

    public OrderDto() {

    }

    public List<OrderItemDto> getItemsofanorder() {
        return itemsofanorder;
    }

    public void setItemsofanorder(List<OrderItemDto> itemsofanorder) {
        this.itemsofanorder = itemsofanorder;
    }
}
