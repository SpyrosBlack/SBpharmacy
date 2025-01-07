package com.nyc.sbpharmacy.controllers;

import com.nyc.sbpharmacy.AppScopeBean;
import com.nyc.sbpharmacy.model.AppUser;
import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.model.dto.DashBoardDto;
import com.nyc.sbpharmacy.service.AppUserService;
import com.nyc.sbpharmacy.service.MessageService;
import com.nyc.sbpharmacy.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AppScopeBean applicationScopeBean;
    @Autowired
    MessageService messageService;

    @Autowired
    private PasswordEncoder passwordEncoder;

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
          //  ddto.setTotalcostoforders(orderService.getOrdersCostTotalByPharmacy(loggedinuser.getPharmacy()));
        }

        mm.addAttribute("mymessages",  messageService.getMyMessages(appUserService.mapToEntity(loggedinuser)));
        mm.addAttribute("dashboard", ddto);
        return "index";
    }

    @GetMapping("/register")
    public String showRegister(ModelMap mm, HttpSession session) {
        RegisterDto registerDto = new RegisterDto("","","","", "");
        mm.addAttribute("registerdto", registerDto);
        return "register";
    }

    @PostMapping("/doregister")
    public String doRegister(@ModelAttribute("registerdto") RegisterDto dto,
                             ModelMap mm,
                             RedirectAttributes redirectAttributes) {
        //Check passwords
        if(!dto.password1.equals(dto.password2)){
            mm.addAttribute("message", "Passwords do not match");
            return "register";
        }
        // Hash the first pass
        String hashedpass = passwordEncoder.encode(dto.password1);
        AppUser user = appUserService.convertDtoToEntity(dto);
        user.setUserpassword(hashedpass);
        appUserService.createUser(user);
        redirectAttributes.addFlashAttribute("message", "User registered successfully. Please login");
        return "redirect:/";
    }

    private record LoginDto(String username, String userpass) {
    }

    public record RegisterDto(String username, String firstname, String lastname, String password1, String password2) {
    }

}
