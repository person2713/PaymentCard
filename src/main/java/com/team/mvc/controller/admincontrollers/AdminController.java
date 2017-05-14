package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        return "redirect:/admin/allUsers";
    }


}
