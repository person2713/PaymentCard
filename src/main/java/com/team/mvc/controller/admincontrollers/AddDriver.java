package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.AppController;
import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Owners;
import com.team.mvc.database.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/addDriver")
public class AddDriver {


    private static final Logger logger = Logger.getLogger(AppController.class.getName());

    @Autowired
    CompanyService companyService;

    @Autowired
    CityService cityService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersonService personService;

    @Autowired
    DriversService driversService;

    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewCompany(ModelMap model) {
        Drivers driver = new Drivers();
        model.addAttribute("driverForm", driver);
        return "admin/addDriver";
    }

    @Transactional
    @RequestMapping(value = "/newDriver", method = RequestMethod.POST)
    public String saveCompany(@Valid @ModelAttribute("driverForm") Drivers driver, BindingResult result,
                              ModelMap model) {

        driver.getPerson().setRole(roleService.findByType("DRIVER"));
        personService.savePerson(driver.getPerson());
        Long personId = personService.findByNickname(driver.getPerson().getNickname()).getPersonId();
        driver.getPerson().setPersonId(personId);
        driversService.save(driver);
        return "/admin/admin";
    }

    @ModelAttribute("cities")
    public List<Cities> initializeCities() {
        return cityService.getAll();
    }


    @ModelAttribute("companies")
    public List<Companies> getCompanies() {
        return companyService.getAll();
    }
}
