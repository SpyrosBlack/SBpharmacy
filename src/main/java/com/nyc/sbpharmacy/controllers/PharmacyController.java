package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.model.Pharmacist;
import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.model.dto.OrderDto;
import com.nyc.sbpharmacy.model.dto.PharmacyDTO;
import com.nyc.sbpharmacy.service.AppUserService;
import com.nyc.sbpharmacy.service.MedicineService;
import com.nyc.sbpharmacy.service.PharmacyService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PharmacyController {

    private final PharmacyService   pharmacyService;

    private final AppUserService appUserService;

    private final MedicineService medicineService;

    public PharmacyController(PharmacyService pharmacyService, AppUserService appUserService, MedicineService medicineService) {
        this.pharmacyService = pharmacyService;
        this.appUserService = appUserService;
        this.medicineService = medicineService;
    }

    @GetMapping("/insertpharm")
    public String pharmpage(ModelMap modelMap) {
        modelMap.addAttribute("pharmacyDTO", new PharmacyDTO());
        return "pharmacyadd.html";
    }

    @PostMapping("/doinsertpharm")
    public String insetrPharm(@ModelAttribute("pharmacyDTO") PharmacyDTO pharmacyDTO) {
        System.out.println(pharmacyDTO);
        //TODO implement this. Only for admins
       pharmacyService.create(pharmacyDTO);
        return "ll";
    }

    @GetMapping("/insertorder")
        public String pharmorder(ModelMap modelMap, HttpSession session) {
            // make a new order
            OrderDto orderDto = new OrderDto();
            modelMap.addAttribute("emptyorder" , orderDto);
            List<Medicine> allmeds = medicineService.getAllMedicine();
        System.out.println(allmeds);
            modelMap.addAttribute("allmedicines", allmeds);
            return "pharmacyorder.html";
        }
}
