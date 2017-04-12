package com.team.mvc.controller;

import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.PersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {



    private static final Logger logger = Logger.getLogger(AppController.class.getName());

    @Autowired
    PersonService personService;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Welcome to the first page of the project");
        return "welcome";
    }

    @RequestMapping(value="/admin/getlAllUsers", method = RequestMethod.GET)
    public @ResponseBody
    List<Persons> getAllUsers(){
        return personService.getAllUser();
    }




    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        return "admin/admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        return "user/user";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {

        if(Flag.isFlag()){
            model.addAttribute("flag",Flag.isFlag());
            Flag.setFlag(false);
        }

// перенавправляем пользователя после его входа и при попытке повторного доступа к страничке login
        if (isCurrentAuthenticationAnonymous())
            return "login";
        else {
            if (GetRole.hasRole("ROLE_ADMIN"))
                return "redirect:/admin";
            else
                return "redirect:/user";
        }
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }



    // метод для проверки авторизации пользователя
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver. isAnonymous(authentication);
    }
}
