package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.model.PharmacyDTO;
import com.nyc.sbpharmacy.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PharmacyController {

    private final PharmacyService   pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping("/insertpharm")
    public String pharmpage(ModelMap modelMap) {
        modelMap.addAttribute("pharmacyDTO", new PharmacyDTO());
        return "pharmacyadd.html";
    }

    @PostMapping("/doinsertpharm")
    public String insetrPharm(@ModelAttribute("pharmacyDTO") PharmacyDTO pharmacyDTO) {
        System.out.println(pharmacyDTO);
       pharmacyService.create(pharmacyDTO);
        return "ll";
    }
}
