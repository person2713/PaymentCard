package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/allCompanies")
public class GetCompanies {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCompanies(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("companies", companyService.getAll());
        return "admin/getCompanies";
    }

}
