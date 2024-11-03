package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Order;
import com.nyc.sbpharmacy.model.OrderItem;
import com.nyc.sbpharmacy.model.Pharmacy;
import com.nyc.sbpharmacy.model.dto.OrderItemDto;
import com.nyc.sbpharmacy.repos.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> getAllOrders(){
        return orderRepo.findAll();
    }
    public List<Order> getAllOrdersByPharm(Pharmacy pharmacy){
        return orderRepo.findByPharmacy(pharmacy);
    }


    public List<Order> getAllOrderForPharmacy(Pharmacy pharmacy){
        return orderRepo.findAll();
    }

    public Order createOrder(Order order){
        return orderRepo.save(order);
    }

    public OrderItem mapToEntity(OrderItemDto dto){
        OrderItem item = new OrderItem();
        item.setMedicine(dto.getMedicine());
        item.setQuantity(dto.getQuantity());
        return item;
    }

}
