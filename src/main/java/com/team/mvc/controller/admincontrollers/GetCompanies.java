package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/allCompanies")
public class GetCompanies {

    @Autowired
    CityService cityService;

    @Autowired
    CompanyService companyService;

    @Autowired
    BusesService busesService;

    @Autowired
    DriversService driversService;

    @Autowired
    RouteService routeService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCompanies(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("companies", companyService.getAll());
        return "admin/getCompanies";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUpdateCompanyForm(@PathVariable("id") long id, Model model) {

        try {
            Companies company = companyService.findById(id);
            model.addAttribute("edit", true);
            model.addAttribute("companyForm", company);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "admin/addCompany";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable("id") long id) {
        try {
            companyService.delete(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/allCompanies";

    }

    @RequestMapping(value = "/editCompany", method = RequestMethod.POST)
    public String saveOrUpdateDriver(@ModelAttribute("companyForm") @Validated Companies company, BindingResult result, Model model) throws NotFoundException {

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!companyService.isCompanyNameUnique(company.getCompanyId(), company.getCompanyName())) {
            model.addAttribute("edit", true);
            FieldError companyNameUniqError = new FieldError("company", "companyName", messageSource.getMessage("non.unique.company.name", new String[]{company.getCompanyName()}, Locale.getDefault()));
            result.addError(companyNameUniqError);
            return "admin/addCompany";
        } else {
            companyService.update(company);
            return "redirect:/admin/allCompanies";
        }
    }

    @ModelAttribute("cities")
    public List<Cities> getAllCities() {
        return cityService.getAll();
    }


}
