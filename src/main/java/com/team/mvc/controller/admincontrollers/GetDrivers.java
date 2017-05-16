package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.CompanyService;
import com.team.mvc.database.services.DriversService;
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
@RequestMapping("/admin/allDrivers")
public class GetDrivers {

    @Autowired
    DriversService driversService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    CityService cityService;

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getDrivers(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("drivers", driversService.getAll());
        return "admin/getDrivers";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUpdateDriverForm(@PathVariable("id") long id, Model model) {

        try {
            Drivers driver = driversService.findById(id);
            model.addAttribute("edit", true);
            model.addAttribute("driverForm", driver);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "admin/addDriver";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteDriver(@PathVariable("id") long id) {
        driversService.delete(id);
        return "redirect:/admin/allDrivers";

    }

    @RequestMapping(value = "/editDriver", method = RequestMethod.POST)
    public String saveOrUpdateDriver(@ModelAttribute("driverForm") @Validated Drivers driver, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!driversService.isDriverNicknameUnique(driver.getPerson().getPersonId(), driver.getPerson().getNickname())) {
            model.addAttribute("edit", true);
            FieldError nicknameUniqError = new FieldError("driver", "person.nickname", messageSource.getMessage("non.unique.driver.nickname", new String[]{driver.getPerson().getNickname()}, Locale.getDefault()));
            result.addError(nicknameUniqError);
            return "admin/addDriver";
        } else {
            driversService.update(driver);
            return "redirect:/admin/allDrivers";
        }
    }

    @ModelAttribute("companies")
    public List<Companies> getAllCompanies() {
        return companyService.getAll();
    }

    @ModelAttribute("cities")
    public List<Cities> getAllCities() {
        return cityService.getAll();
    }

}
