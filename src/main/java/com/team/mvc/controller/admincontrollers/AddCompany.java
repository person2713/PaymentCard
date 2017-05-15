package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/addCompany")
public class AddCompany {

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

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewCompany(ModelMap model) {
        Companies company = new Companies();
        model.addAttribute("companyForm", company);
        return "admin/addCompany";
    }

    @RequestMapping(value = "/newCompany", method = RequestMethod.POST)
    public String saveCompany(@Valid @ModelAttribute("companyForm") Companies companies) {
        System.out.println("::fsdfsd");
        companyService.saveCompany(companies);
        return "/admin/admin";
    }

    @ModelAttribute("cities")
    public List<Cities> getAllCities() {
        return cityService.getAll();
    }

    @ModelAttribute("buses")
    public List<Buses> getAllBuses() {
        return busesService.getAll();
    }

    @ModelAttribute("drivers")
    public List<Drivers> getAllDrivers() {
        return driversService.getAll();
    }

    @ModelAttribute("routes")
    public List<Routes> getAllRoutes() {
        return routeService.getAll();
    }
}
