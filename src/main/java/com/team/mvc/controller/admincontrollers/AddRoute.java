package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.services.CompanyService;
import com.team.mvc.database.services.RoutesService;
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
@RequestMapping("/admin/addRoute")
public class AddRoute {

    @Autowired
    RoutesService routesService;

    @Autowired
    CompanyService companyService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewBus(ModelMap model) {
        Routes route = new Routes();
        model.addAttribute("routeForm", route);
        return "admin/addRoute";
    }

    @RequestMapping(value = "/newRoute", method = RequestMethod.POST)
    public String saveBus(@Valid @ModelAttribute("routeForm") Routes route, BindingResult result) {

        try {
            if (result.hasErrors()) {
                return "errorPage";
             }
            if (!routesService.isRouteNumberUnique(route.getRouteId(), route.getRouteNumber())) {
                FieldError routeNumberUniqError = new FieldError("route", "routeNumber", messageSource.getMessage("non.unique.route.number", new String[]{route.getRouteNumber()}, Locale.getDefault()));
                result.addError(routeNumberUniqError);
                return "admin/addRoute";
            } else {
                routesService.save(route);
                return "redirect:/admin/allRoutes";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "errorPage";
        }

    }

    @ModelAttribute("companies")
    public List<Companies> getAllCompanies() {
        return companyService.getAll();
    }
}
