package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.service.AppUserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
private record LoginDto(String username, String userpass) {}

@Autowired
private AppUserService  appUserService;



    @GetMapping("/")
    public String showMainPage(ModelMap mm) {
mm.addAttribute("login", new LoginDto("", ""));
        return "login.html";
    }

    @PostMapping("/dologin")
    public String doLogin(@ModelAttribute("loginDTO") LoginDto dto, ModelMap mm, HttpSession session) {
        AppUserDto loggedinuser = appUserService.dologin(dto.username, dto.userpass);
        if (loggedinuser == null) {
            mm.addAttribute("message", "Wrong user name or password");
            return "login.html";
        }else{
            session.setAttribute("loggedinuser", loggedinuser);
            return "index.html";
        }

    }

}
