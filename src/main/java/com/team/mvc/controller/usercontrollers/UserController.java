package com.team.mvc.controller.usercontrollers;


import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.CardService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.TypeCardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user/user")
public class UserController {

    @Autowired
    PersonService userService;

    @Autowired
    CardService cardService;

    @Autowired
    TypeCardService typeCardService;




    @ModelAttribute("person")
    public Persons InitializePerson() {
        return userService.findByNickname(getPrincipal());
    }
    @ModelAttribute("cards")
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
    }


    @RequestMapping(method = RequestMethod.GET)
    public String userPage(ModelMap model) throws NotFoundException {
        System.out.println(getPrincipal());

        //model.addAttribute("cards", InitializeCards());

     /*   Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", getPrincipal());
        Persons customUser = (Persons)auth.getPrincipal();
        int userId = (int) customUser.getPersonId();
        Persons users = userService.findById(userId);
        // Persons users = userService.findById(1);
         model.addAttribute("users", users);*/

        return "/user";
    }



    /*@RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public
    @ResponseBody
    String addCard(@RequestBody List<String> list) {

        System.out.println("ADDCARD");
        for (String s : list) {
            System.out.println(s);
        }
        if (list.isEmpty()) {
            return "FAILRY";
        } else {
            Cards cards = new Cards();
            cards.setCardName(list.get(0));
            cards.setCardKey(Long.parseLong(list.get(1)));
            cards.setTypeCard(typeCardService.getTypeCardbyStatus("active"));
            cards.setPerson(userService.findByNickname(list.get(2)));
            cardService.saveCard(cards);
            return "SUCCESS";
        }

    }*/


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
