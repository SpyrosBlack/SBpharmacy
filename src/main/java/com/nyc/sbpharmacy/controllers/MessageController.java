package com.nyc.sbpharmacy.controllers;


import com.nyc.sbpharmacy.model.Message;
import com.nyc.sbpharmacy.model.dto.AppUserDto;
import com.nyc.sbpharmacy.service.AppUserService;
import com.nyc.sbpharmacy.service.MessageService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MessageController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    MessageService messageService;

    @GetMapping("/newmessage")
    public String newMessage(ModelMap model, HttpSession session) {
        Message message = new Message();

        // populate the receivers list
        AppUserDto loggedinuser = (AppUserDto) session.getAttribute("loggedinuser");
        List<AppUserDto> allusers = appUserService.getAllUsersDto();
//        allusers.removeIf(u -> u.getUsername().equals(loggedinuser.getUsername()));
        allusers.remove(loggedinuser);
        model.addAttribute("receivers", allusers);
        model.addAttribute("message", message);
        return "newmessageform";
    }

    @PostMapping("/insertmessage")
    public String insertMessage(@ModelAttribute Message message, ModelMap model,
                                HttpSession session, RedirectAttributes attributes) {
        AppUserDto loggedinuser = (AppUserDto) session.getAttribute("loggedinuser");

        message.setSender( appUserService.mapToEntity(loggedinuser));
        message.setSenddate(LocalDateTime.now());
        messageService.insertMessage(message);
        attributes.addFlashAttribute("infomessage", "Message sent successfully");
        return "redirect:/showdashboard";
    }
}
