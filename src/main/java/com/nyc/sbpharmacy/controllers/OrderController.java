package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.model.Order;
import com.nyc.sbpharmacy.model.OrderItem;
import com.nyc.sbpharmacy.model.dto.OrderDto;
import com.nyc.sbpharmacy.model.dto.OrderItemDto;
import com.nyc.sbpharmacy.service.AppUserService;
import com.nyc.sbpharmacy.service.MedicineService;
import com.nyc.sbpharmacy.service.OrderService;
import com.nyc.sbpharmacy.service.PharmacyService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    private final AppUserService appUserService;
    private final PharmacyService pharmacyService;
    private final MedicineService medicineService;
    private final OrderService orderService;
    private List<OrderItemDto> tempItemsList = new ArrayList<>();

    public OrderController(AppUserService appUserService, PharmacyService pharmacyService, MedicineService medicineService, OrderService orderService) {
        this.appUserService = appUserService;
        this.pharmacyService = pharmacyService;
        this.medicineService = medicineService;
        this.orderService = orderService;
    }

    @GetMapping("/insertorder")
    public String pharmorder(ModelMap modelMap) {
        // Make one OrderItemDto and put it in the model
        OrderItemDto tempitem = new OrderItemDto();
        modelMap.addAttribute("tempitem", tempitem);
       // I need all the medicines for the dropdown
        modelMap.addAttribute("allmedicines",  medicineService.getAllMedicine());
        // Put the partial submitted items in the model
        return "pharmacyorder.html";
    }

    @PostMapping(value = "dopartialorder")
    public String doPartialOrder(@ModelAttribute OrderItemDto orderItem, HttpSession session) {
        // take the order item, put it in the session of the user and return the same page
       tempItemsList.add(orderItem);
       session.setAttribute("tempItemsList", tempItemsList);
        return "redirect:/insertorder";
    }

    @GetMapping("/orders")
    public String showAllorders(ModelMap modelMap) {
        modelMap.addAttribute("allorders", orderService.getAllOrders());
        return "allorders.html";
    }

    @PostMapping(value = "dopinsertorder")
    public String doInserOrder( HttpSession session) {
        // take all the the order items,from the session
        List <OrderItemDto> orderitems = (List<OrderItemDto>) session.getAttribute("tempItemsList");
        Order myorder = new Order();
        myorder.setItems(orderitems.stream().map(o->orderService.mapToEntity(o)).toList());
        //TODO Get Pharmacist
        myorder.setOrderdate(LocalDate.now());



        session.removeAttribute("tempItemsList"); // clear the session
        return "redirect:/insertorder";
    }
}
