package com.nyc.sbpharmacy.service;

import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.model.Order;
import com.nyc.sbpharmacy.model.OrderItem;
import com.nyc.sbpharmacy.model.Pharmacy;
import com.nyc.sbpharmacy.model.dto.OrderItemDto;
import com.nyc.sbpharmacy.repos.MedicineRepo;
import com.nyc.sbpharmacy.repos.OrderItemRepo;
import com.nyc.sbpharmacy.repos.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    private final OrderItemRepo orderItemRepo;

    private final MedicineRepo medicineRepo;
    private final InventoryService inventoryService;

    public OrderService(OrderRepo orderRepo, OrderItemRepo orderItemRepo, MedicineRepo medicineRepo, InventoryService inventoryService) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
        this.medicineRepo = medicineRepo;
        this.inventoryService = inventoryService;
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public List<Order> getAllOrdersByPharm(Pharmacy pharmacy) {
        return orderRepo.findByPharmacy(pharmacy);
    }

    public Medicine getMedicineById(Integer id) {
        return medicineRepo.getReferenceById(id);
    }

    public List<Order> getAllOrderForPharmacy(Pharmacy pharmacy) {
        return orderRepo.findAll();
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public int getInventoryForMedicineAndPharmacy(Integer medicineid, Pharmacy pharmacy) {
        Medicine medicine = medicineRepo.getReferenceById(medicineid);
        return inventoryService.fetchInventoryforMedicine(pharmacy, medicine);
    }

    public float getOrdersCostTotalByPharmacy(Pharmacy pharmacy) {
        return orderRepo.costTotal(pharmacy);

    }


    public OrderItem mapToEntity(OrderItemDto dto) {
        OrderItem item = new OrderItem();
        item.setMedicine(dto.getMedicine());
        item.setQuantity(dto.getQuantity());
        return item;
    }

//    public OrderItemDto mapToDto(OrderItem orderItem){
//        OrderItemDto item = new OrderItemDto();
//        item.setMedicine(orderItem.getMedicine());
//        item.setQuantity(orderItem.getQuantity());
//        return item;
//    }

    public List<OrderItemDto> removeFromOrderByMedicineId(List<OrderItemDto> orders, Integer medicineid) {
        OrderItemDto tempdto = new OrderItemDto();
        for (OrderItemDto o : orders) {
            if (o.getMedicine().getMedicineid().equals(medicineid)) {
                tempdto = o;
            }
        }
        orders.remove(tempdto);
        return orders;
    }

    public OrderItem getOrderItemById(Integer id) {
        return orderItemRepo.findById(id).get();
    }

    public void completeOrderItem(Integer id) {
        OrderItem temp = getOrderItemById(id);
        //TODO Update stock of pharmacy?
        temp.setDone(true);
        orderItemRepo.save(temp);
    }

}
