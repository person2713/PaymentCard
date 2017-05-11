package com.team.mvc.controller.usercontrollers;


import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.CardsService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.TypeCardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private PersonService personService;
    @Autowired
    CardsService cardsService;



    @Autowired
    public void setUserService(PersonService personService) {
        this.personService = personService;
    }





    // list page
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showAllUsers(Model model) {

      //  System.out.println( personService.findCradsByNickname(GetRole.getPrincipal()).toString());
        model.addAttribute("cards", personService.findCradsByNickname(GetRole.getPrincipal()));
        return "user/list";

    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model) throws NotFoundException {
        System.out.println("-------------------showUser-------------------"+id );


           Cards cards =personService.findByCardbyID(id);
        System.out.println(cards.toString()+"--------------------------------");

        if (cards == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("card", cards);

        return "user/show";

    }





}
