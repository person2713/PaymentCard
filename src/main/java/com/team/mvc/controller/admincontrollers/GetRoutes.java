package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.services.BusesService;
import com.team.mvc.database.services.CompanyService;
import com.team.mvc.database.services.RoutesService;
import javassist.NotFoundException;
import org.jgroups.protocols.relay.Relayer;
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
@RequestMapping("/admin/allRoutes")
public class GetRoutes {

    @Autowired
    RoutesService routesService;

    @Autowired
    CompanyService companyService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getRoutes(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("routes", routesService.getAll());
        return "admin/getRoutes";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUpdateRouteForm(@PathVariable("id") long id, Model model) {

        try {
            Routes route = routesService.findById(id);
            model.addAttribute("edit", true);
            model.addAttribute("routeForm", route);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return "errorPage";
        }
        return "admin/addRoute";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteRoute(@PathVariable("id") long id) {
        try {
            routesService.delete(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return "errorPage";
        }
        return "redirect:/admin/allRoutes";

    }

    @RequestMapping(value = "/editRoute", method = RequestMethod.POST)
    public String saveOrUpdateDriver(@ModelAttribute("routeForm") @Validated Routes route, BindingResult result, Model model) throws NotFoundException {

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!routesService.isRouteNumberUnique(route.getRouteId(), route.getRouteNumber())) {
            model.addAttribute("edit", true);
            FieldError routeNumberUniqError = new FieldError("route", "routeNumber", messageSource.getMessage("non.unique.route.number", new String[]{route.getRouteNumber()}, Locale.getDefault()));
            result.addError(routeNumberUniqError);
            return "admin/addRoute";
        } else {
            routesService.update(route);
            return "redirect:/admin/allRoutes";
        }
    }

    @ModelAttribute("companies")
    public List<Companies> getAllCompanies() {
        return companyService.getAll();
    }
}
