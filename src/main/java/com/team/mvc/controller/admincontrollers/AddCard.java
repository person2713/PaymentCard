package com.team.mvc.controller.admincontrollers;


import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.*;
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
    TypeCardService  typeCardService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddCard(ModelMap model) {
        Cards card = new Cards();
        model.addAttribute("cardForm", card);
        return "/admin/addCard";
    }

    @RequestMapping(value = "/newCard", method = RequestMethod.POST)
    public String saveCard(@Valid @ModelAttribute("cardForm") Cards card, BindingResult result,
                           ModelMap model) {
        card.setTypeCard(typeCardService.getTypeCardbyStatus("active"));
        cardService.saveCard(card);
        return "success";
    }

//    @ModelAttribute("typeCard")
//    public List<TypeCard> getRollers() { return typeCardService.getAll();}

    @ModelAttribute("persons")
    public List<Persons> initializeCities() {
        return personService.getAllUser();
    }




}
