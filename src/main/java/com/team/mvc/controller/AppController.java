package com.team.mvc.controller;

import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.services.BlackListService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import com.team.mvc.database.services.BlackListService;

@Controller
@RequestMapping("/")
public class AppController {



    private static final Logger logger = Logger.getLogger(AppController.class.getName());


    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
    @Autowired
    BlackListService blackListService;

    @ModelAttribute("blockCards")
    public List<Cards> getAllBlockCards() { return blackListService.getAllBlockCards();}

   /* @RequestMapping(value = "/blockCards/", method = RequestMethod.GET)
    public ResponseEntity<List<Cards>> listAllBlockCards() {
        List<Cards> cardsList = blackListService.getAllBlockCards();
        if(cardsList.isEmpty()){
            return new ResponseEntity< List<Cards>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity< List<Cards>>(cardsList, HttpStatus.OK);
    }*/



    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Welcome to the first page of the project");
        return "welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(ModelMap model) {
        model.addAttribute("user", GetRole.getPrincipal());
        return "admin/admin";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String userPage(ModelMap model) {
        model.addAttribute("user", GetRole.getPrincipal());
        return "user/user";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", GetRole.getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        // как перенаправить пользователя на определенную страницу в зависимости от роли?
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


    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver. isAnonymous(authentication);
    }
}
