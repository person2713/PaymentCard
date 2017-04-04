package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin/getAlluser")
public class GetAllUser {

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<Persons> persons = personService.getAllUser();
        model.addAttribute("persons", persons);
        return "admin/getAlluser";
    }
}
