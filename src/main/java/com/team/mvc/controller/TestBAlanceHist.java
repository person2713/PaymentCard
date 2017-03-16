package com.team.mvc.controller;

import com.team.mvc.dao.BalanceHistDaoImpl;
import com.team.mvc.entity.BalanceHistEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vit on 16.03.2017.
 */
@Controller
public class TestBAlanceHist {
    @Autowired(required = true)
    private BalanceHistDaoImpl BalanceHistDaoImpl;
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String viewLogin(Model model) {
        model.addAttribute("admin", new BalanceHistEntity());
        return "/index";
    }
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String login(@ModelAttribute("admin") Admin admin, Model model) {
        if (admin.getUsername() != null) {
            Admin registeredAdmin = adminService.getAdmin(admin.getUsername());
            if(registeredAdmin!=null){
                model.addAttribute("message", "Welcome "+admin.getUsername());
                model.addAttribute("messageType","information");
            }else{
                model.addAttribute("message", "User not found");
                model.addAttribute("messageType","warning");
            }
        } else {
            model.addAttribute("message", "User not found");
            model.addAttribute("messageType","warning");
        }
        return "/index";
    }
}
