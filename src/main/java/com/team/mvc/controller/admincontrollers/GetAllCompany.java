package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.CompanyService;
import com.team.mvc.database.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/admin/getAllcompany")
public class GetAllCompany {

    @Autowired
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public String listCompany(ModelMap model) {

        List<Companies> companies = companyService.getAll();
        model.addAttribute("companies", companies);
        return "/admin/getAllcompany";
    }
}
