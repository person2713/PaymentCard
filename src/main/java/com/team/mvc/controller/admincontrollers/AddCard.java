package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/addCard")
public class AddCard {

    @Autowired
    PersonService personService;

    @Autowired
    CardService cardService;

    @Autowired
    TypeCardService typeCardService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewCard(ModelMap model) {
        Cards card = new Cards();
        model.addAttribute("cardForm", card);
        return "admin/addCard";
    }

    @RequestMapping(value = "/newCard", method = RequestMethod.POST)
    public String saveCard(@Valid @ModelAttribute("cardForm") Cards card) {
        card.setTypeCard(typeCardService.getTypeCardbyStatus("active"));
        cardService.saveCard(card);
        return "/admin/allCards";
    }

    @ModelAttribute("persons")
    public List<Persons> getAllUsers() {
        return personService.getUsers();
    }




}
