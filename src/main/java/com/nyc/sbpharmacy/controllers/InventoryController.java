package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.service.AppUserService;
import com.nyc.sbpharmacy.service.InventoryService;
import com.nyc.sbpharmacy.service.PharmacyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private PharmacyService pharmacyService;


    @GetMapping("/getinventory")
    public String getAllInventory(ModelMap modelmap, HttpSession session) {
        AppUser user = appUserService.mapToEntity((AppUserDto) session.getAttribute("loggedinuser"));
        modelmap.addAttribute("inventory",
                inventoryService.getPharmacyInventory(pharmacyService.getPharmacyFromUser(user)));
        return "inventorytable";
    }

    @GetMapping("/warehouseinventory")
    public String getWarehouseInventory(ModelMap modelmap, HttpSession session, Model model) {
        modelmap.addAttribute("inventory", inventoryService.getInventoryWarehouses());
        return "inventorytable";
    }
}
