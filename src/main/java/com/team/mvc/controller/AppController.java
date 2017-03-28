package com.team.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Rollers;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/")
public class AppController {


//    @Autowired
//    PersonService personService;
//
//    @Autowired
//    MessageSource messageSource;
//
//    @Autowired
//    RoleService roleService;


    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hello on first page");
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin/admin";
    }

    @RequestMapping(value = "/driver", method = RequestMethod.GET)
    public String driverPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "driver/driver";
    }


    @RequestMapping(value = "/owner", method = RequestMethod.GET)
    public String ownerPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "owner/owner";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "user/user";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }




//    @ModelAttribute("roles")
//    public List<Rollers> initializeProfiles() {
//        return roleService.findAll();
//    }

//    @RequestMapping(value = "/registration", method = RequestMethod.GET)
//    public String registrationPage() {
//        return "registration";
//    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

    private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
