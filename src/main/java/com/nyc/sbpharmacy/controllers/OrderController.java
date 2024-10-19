package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.model.Order;
import com.nyc.sbpharmacy.model.Pharmacist;
import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.service.AppUserService;
import com.nyc.sbpharmacy.service.PharmacyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    private final AppUserService appUserService;
    private final PharmacyService pharmacyService;

    public OrderController(AppUserService appUserService, PharmacyService pharmacyService) {
        this.appUserService = appUserService;
        this.pharmacyService = pharmacyService;
    }

    @PostMapping("doinsertorder")
    public String doinsertorder(@ModelAttribute Order order, HttpSession session) {
        AppUserDto dto = (AppUserDto) session.getAttribute("loggedinuser");
        // It must be a pharmacist, so get the entity
        Pharmacist p = appUserService.getPharmacyForUser(dto);
        order.setPharmacy(p.getPharmacy());
        pharmacyService.createOrder(order);
        return "redirect:/orders";
    }

}
