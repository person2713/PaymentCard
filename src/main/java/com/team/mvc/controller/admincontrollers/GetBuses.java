package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.services.BusesService;
import com.team.mvc.database.services.CompanyService;
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
@RequestMapping("/admin/allBuses")
public class GetBuses {

    @Autowired
    BusesService busesService;

    @Autowired
    CompanyService companyService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getBuses(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("buses", busesService.getAll());
        return "admin/getBuses";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUpdateBusForm(@PathVariable("id") long id, Model model) {

        try {
            Buses bus = busesService.findById(id);
            model.addAttribute("edit", true);
            model.addAttribute("busForm", bus);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "admin/addBus";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteCompany(@PathVariable("id") long id) {
        try {
            busesService.delete(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/admin/allBuses";

    }

    @RequestMapping(value = "/editBus", method = RequestMethod.POST)
    public String saveOrUpdateDriver(@ModelAttribute("busForm") @Validated Buses bus, BindingResult result, Model model) throws NotFoundException {

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!busesService.isBusNumberUnique(bus.getBusId(), bus.getBusNumber())) {
            model.addAttribute("edit", true);
            FieldError companyNameUniqError = new FieldError("bus", "busNumber", messageSource.getMessage("non.unique.bus.number", new String[]{bus.getBusNumber()}, Locale.getDefault()));
            result.addError(companyNameUniqError);
            return "admin/addBus";
        } else {
            busesService.update(bus);
            return "redirect:/admin/allBuses";
        }
    }

    @ModelAttribute("companies")
    public List<Companies> getAllCompanies() {
        return companyService.getAll();
    }

}
