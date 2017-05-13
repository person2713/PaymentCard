package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.services.CompanyService;
import com.team.mvc.database.services.RouteService;
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
@RequestMapping("/admin/addRoute")
public class AddRoute {

    @Autowired
    RouteService routeService;

    @Autowired
    CompanyService companyService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewBus(ModelMap model) {
        Routes route = new Routes();
        model.addAttribute("routeForm", route);
        return "admin/addRoute";
    }

    @RequestMapping(value = "/newRoute", method = RequestMethod.POST)
    public String saveBus(@Valid @ModelAttribute("routeForm") Routes route, BindingResult result,
                          ModelMap model) {
        routeService.save(route);
        return "/admin/admin";
    }

    @ModelAttribute("companies")
    public List<Companies> getAllCompanies() {
        return companyService.getAll();
    }
}
