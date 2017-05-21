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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

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
    DriversService driversService;

    @Autowired
    PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewDriver(ModelMap model) {
        Drivers driver = new Drivers();
        model.addAttribute("driverForm", driver);
        return "admin/addDriver";
    }


    @RequestMapping(value = "/newDriver", method = RequestMethod.POST)
    public String saveDriver(@Valid @ModelAttribute("driverForm") Drivers driver, BindingResult result) {

        List<FieldError> listError = new ArrayList<>();

        try {
            if (result.hasErrors()) {
                return "errorPage";
            }

            if (!personService.isPersonsNicknameUnique(driver.getPerson().getPersonId(), driver.getPerson().getNickname())) {
                FieldError nicknameUniqError = new FieldError("driver", "person.nickname", messageSource.getMessage("non.unique.driver.nickname", new String[]{driver.getPerson().getNickname()}, Locale.getDefault()));
                listError.add(nicknameUniqError);
            }
            if (!personService.isPersonsEmailUnique(driver.getPerson().getPersonId(), driver.getPerson().getEmail())) {
                FieldError emailUniqError = new FieldError("driver", "person.email", messageSource.getMessage("non.unique.driver.email", new String[]{driver.getPerson().getEmail()}, Locale.getDefault()));
                listError.add(emailUniqError);
            }
            if (!personService.isPersonsMobileUnique(driver.getPerson().getPersonId(), driver.getPerson().getMobileNumber())) {
                FieldError mobileUniqError = new FieldError("driver", "person.mobileNumber", messageSource.getMessage("non.unique.driver.mobileNumber", new String[]{driver.getPerson().getMobileNumber()}, Locale.getDefault()));
                listError.add(mobileUniqError);
            }

            if(!listError.isEmpty()){
                for (FieldError fieldError: listError) {
                    result.addError(fieldError);
                }
                return "admin/addDriver";
            }
            else {
                driversService.save(driver);
                return "redirect:/admin/allDrivers";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "errorPage";
        }

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
