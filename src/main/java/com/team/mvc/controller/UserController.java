package com.team.mvc.controller;


import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.PersonService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user/user")
public class UserController {

    @Autowired
    PersonService userService;

    @ModelAttribute("person")
    public Persons InitializePerson() {
        return userService.findByNickname(getPrincipal());
    }
  /*  @ModelAttribute("cards")
    public List<Cards> InitializeCards() {
        return userService.findCradsByNickname(getPrincipal());
    }

    @ModelAttribute("balance")
    public CardBalance InitializeBalance() {
        return userService.findBalanceByNickname(getPrincipal());
    }
    @ModelAttribute("balanceHist")
    public List<BalanceHist> InitializeBalanceHist() {
        return userService.findBalanceHistByNickname(getPrincipal());}

    @ModelAttribute("events")
    public List<Events> InitializeEvents() {
        return userService.findEventsByNickname(getPrincipal());
    }*/


    @RequestMapping(method = RequestMethod.GET)
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
