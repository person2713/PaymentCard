package com.team.mvc.controller.admincontrollers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/AddUser")
public class AddUser {

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddUser(ModelMap model) {

        return "redirect:/registration";
    }

}
