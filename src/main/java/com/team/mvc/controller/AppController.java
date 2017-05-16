package com.team.mvc.controller;

import com.team.mvc.database.entities.BalanceHist;
import com.team.mvc.database.entities.CarAssign;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Owners;
import com.team.mvc.database.repositories.*;
import com.team.mvc.database.services.CardsService;
import com.team.mvc.database.services.DriversService;
import com.team.mvc.database.services.OwnerService;
import javassist.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    OwnerService ownerService;

    @Autowired
    CarAssignRepository carAssignRepository;

    @Autowired
    CardsService cardsService;

    @Autowired
    BalanceHistRepository balanceHistRepository;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) throws NotFoundException {
        model.addAttribute("greeting", "Welcome to the first page of the project");
        List<BalanceHist> list = balanceHistRepository.getAllHistForCard((long) 14);
        return "welcome";
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


    //мапинг на проверку странички ввода нового пароля
   /* @RequestMapping(value = "/reset_pass", method = RequestMethod.GET)
    public String resetPassPage(ModelMap model) {
        return "enter_new_pass";
    }*/


    @RequestMapping(value = "/login", method = RequestMethod.GET)

    public String loginPage() {
        return "login";
    }


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

    // метод для проверки авторизации пользователя
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);

    }
}
