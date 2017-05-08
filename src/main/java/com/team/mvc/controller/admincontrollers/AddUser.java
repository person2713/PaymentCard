package com.team.mvc.controller.admincontrollers;


import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Rollers;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin/addUser")
public class AddUser {

    @Autowired
    PersonService personService;

    @Autowired
    CityService cityService;



    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddUser(ModelMap model) {
        Persons person = new Persons();
        model.addAttribute("userForm", person);
        model.addAttribute("edit", false);
        return "/admin/addUser";
    }


    @ModelAttribute("rollers")
    public List<Rollers> getRollers() { return roleService.findAll();}

    @ModelAttribute("cities")
    public List<Cities> initializeCities() {
        return cityService.getAll();
    }




}
