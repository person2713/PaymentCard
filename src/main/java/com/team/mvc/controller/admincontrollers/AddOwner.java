package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.AppController;
import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Companies;
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
@RequestMapping("/admin/addOwner")
public class AddOwner {

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
    OwnerService ownerService;

    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewOwner(ModelMap model) {
        Owners owner = new Owners();
        model.addAttribute("ownerForm", owner);
        return "admin/addOwner";
    }

    @Transactional
    @RequestMapping(value = "/newOwner", method = RequestMethod.POST)
    public String saveOwner(@Valid @ModelAttribute("ownerForm") Owners owner, BindingResult result,
                              ModelMap model) {
        owner.getPerson().setRole(roleService.findByType("OWNER"));
        personService.savePerson(owner.getPerson());
        Long personId = personService.findByNickname(owner.getPerson().getNickname()).getPersonId();
        owner.getPerson().setPersonId(personId);
        ownerService.saveOwner(owner);
        return "/admin/admin";
    }

    @ModelAttribute("cities")
    public List<Cities> getAllCities() {
        return cityService.getAll();
    }

    @ModelAttribute("companies")
    public List<Companies> getCompanies() {
        return companyService.getAll();
    }

}