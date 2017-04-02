package com.team.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.services.CustomUserDetailsService;

import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Rollers;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;
import javassist.NotFoundException;
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
    @Autowired
    PersonService userService;




    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Welcome to the first page of the project");
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "admin/admin";
    }
    @ModelAttribute("person")
    public Persons InitializePerson() {
        return userService.findByNickname(getPrincipal());
    }
    @ModelAttribute("cards")
    public List<Cards> InitializeCards() {
        return userService.findCradsByNickname(getPrincipal());
    }



    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) throws NotFoundException {


     /*   Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("user", getPrincipal());
        Persons customUser = (Persons)auth.getPrincipal();
        int userId = (int) customUser.getPersonId();

        Persons users = userService.findById(userId);


        // Persons users = userService.findById(1);
         model.addAttribute("users", users);*/




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
