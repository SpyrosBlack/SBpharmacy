package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.AppScopeBean;
import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.model.dto.DashBoardDto;
import com.nyc.sbpharmacy.service.AppUserService;
import com.nyc.sbpharmacy.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AppScopeBean applicationScopeBean;

    @GetMapping("/")
    public String showMainPage(ModelMap mm) {
        mm.addAttribute("login", new LoginDto("", ""));
        return "login.html";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        applicationScopeBean.setNumberofusers(applicationScopeBean.getNumberofusers() - 1);
        return "redirect:/";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("loginDTO") LoginDto dto, ModelMap mm, HttpSession session) {
        AppUserDto loggedinuser = appUserService.dologin(dto.username, dto.userpass);
        if (loggedinuser == null) {
            mm.addAttribute("message", "Wrong user name or password");
            return "login.html";
        } else {
            //System.out.println("------------------"+applicationScopeBean.getNumberofusers());
            applicationScopeBean.setNumberofusers(applicationScopeBean.getNumberofusers() + 1);
            session.setAttribute("loggedinuser", loggedinuser);
            return "redirect:/showdashboard";
        }

    }

    @GetMapping("/showdashboard")
    public String showDashboard(ModelMap mm, HttpSession session) {
        DashBoardDto ddto = new DashBoardDto();
        AppUserDto loggedinuser = (AppUserDto) session.getAttribute("loggedinuser");


        ddto.setTotalorders(orderService.getAllOrderForPharmacy(loggedinuser.getPharmacy()).size());
        if (loggedinuser.getRole() == "Pharmacist") {
            ddto.setTotalcostoforders(orderService.getOrdersCostTotalByPharmacy(loggedinuser.getPharmacy()));
        }


        mm.addAttribute("dashboard", ddto);
        return "index";
    }

    private record LoginDto(String username, String userpass) {
    }

}
