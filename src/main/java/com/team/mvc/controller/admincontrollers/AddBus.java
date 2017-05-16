package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.services.BusesService;
import com.team.mvc.database.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/addBus")
public class AddBus {

    @Autowired
    BusesService busesService;

    @Autowired
    CompanyService companyService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewBus(ModelMap model) {
        Buses bus = new Buses();
        model.addAttribute("busForm", bus);
        return "admin/addBus";
    }

    @RequestMapping(value = "/newBus", method = RequestMethod.POST)
    public String saveBus(@Valid @ModelAttribute("busForm") Buses bus, BindingResult result) {

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!busesService.isBusNumberUnique(bus.getBusId(), bus.getBusNumber())) {
            FieldError busNumberUniqError = new FieldError("bus", "busNumber", messageSource.getMessage("non.unique.bus.number", new String[]{bus.getBusNumber()}, Locale.getDefault()));
            result.addError(busNumberUniqError);
            return "admin/addBus";
        } else {
            busesService.save(bus);
            return "redirect:/admin/allBuses";
        }
    }

    @ModelAttribute("companies")
    public List<Companies> getAllCompanies() {
        return companyService.getAll();
    }
}
