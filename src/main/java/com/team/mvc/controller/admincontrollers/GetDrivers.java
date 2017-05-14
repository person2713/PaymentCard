package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.services.DriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/allDrivers")
public class GetDrivers {

    @Autowired
    DriversService driversService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getDrivers(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("drivers", driversService.getAll());
        return "admin/getDrivers";
    }

}
