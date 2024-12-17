package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.model.Medicine;
import com.nyc.sbpharmacy.service.MedicineService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @GetMapping("/insertmed")
    public String showMedicineForm(ModelMap modelMap) {
        Medicine medicine = new Medicine();
        modelMap.addAttribute("medicine", medicine);
        return "medicineform";
    }

    @PostMapping("/doinsertmed")
    public String doInsertMedicine(@Valid @ModelAttribute Medicine medicine, BindingResult result,
                                   ModelMap modelMap,
                                   RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "medicineform";
        }
        medicineService.insertMedicine(medicine);
        redirectAttributes.addFlashAttribute("infomessage", "Medicine " + medicine.getMedicinename() + "" +
                "inserted successfully");

        return "redirect:/showdashboard";
    }

    @GetMapping("/allmed")
    public String showAllMedicine(ModelMap modelMap) {
        modelMap.addAttribute("medicines", medicineService.getAllNotDisabledMedicine());
        return "allmedicinetable";
    }

    @GetMapping("/medicineedit/{medicineid}")
    public String updateMedicine(@PathVariable(name = "medicineid") final Integer medicineid,
                                 ModelMap modelMap) {
        modelMap.addAttribute("medicine", medicineService.getMedicineById(medicineid));
        return "medicineedit";
    }

    @PostMapping("/doupdatemed")
    public String doUpdateMedicine(@Valid @ModelAttribute Medicine medicine, BindingResult result) {
        if (result.hasErrors()) {
            return "medicineedit";
        }
        medicineService.updateMedicine(medicine);
        return "redirect:/allmed";
    }

    @PostMapping("/medicinedelete/{medicineid}")
    public String deleteMedicine(@PathVariable(name = "medicineid") final Integer medicineid,
                                 ModelMap modelMap) {
        medicineService.disableMedicineById(medicineid);
        return "redirect:/allmed";
    }

}
