package com.team.mvc.controller;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/")
public class AppController {


    private static final Logger logger = Logger.getLogger(AppController.class.getName());

    @Autowired
    CityService cityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    PersonService personService;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    RoleService roleService;


    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Payment Card system");
        return "welcome";
    }


    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welcomePage(ModelMap model) {
        return "welcome";
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

    @RequestMapping(value = "/reset_pass", method = RequestMethod.GET)
    public String resetPassPage(ModelMap model) {
        return "reset_pass";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model) {

        if (Flag.isFlag()) {
            model.addAttribute("flag", Flag.isFlag());
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

    @ModelAttribute("cities")
    public List<Cities> initializeCities() {
        return cityService.getAll();
    }


    // метод для проверки авторизации пользователя
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
}
