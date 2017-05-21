package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.CardBalance;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.*;
import javassist.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/addCard")
public class AddCard {

    @Autowired
    PersonService personService;

    @Autowired
    CardsService cardService;

    @Autowired
    TypeCardService typeCardService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewCard(ModelMap model) {
        Cards card = new Cards();
        model.addAttribute("cardForm", card);
        return "admin/addCard";
    }

    @RequestMapping(value = "/newCard", method = RequestMethod.POST)
    public String saveCard(@Valid @ModelAttribute("cardForm") Cards card, BindingResult result) {

        List<FieldError> errors = new ArrayList<>();

        try {
            if (result.hasErrors()) {
                return "errorPage";
            }
            if (!cardService.isCardNameUnique(card.getCardId(), card.getCardName())) {
                FieldError cardNameUniqError = new FieldError("card", "cardName", messageSource.getMessage("non.unique.card.cardName", new String[]{card.getCardName()}, Locale.getDefault()));
                errors.add(cardNameUniqError);
            }
            try {
                if (!cardService.isCardKeyUnique(card.getCardId(), card.getCardKey())) {
                    FieldError cardKeyUniqError = new FieldError("card", "cardKey", messageSource.getMessage("non.unique.card.cardKey", new String[]{card.getCardKey().toString()}, Locale.getDefault()));
                    errors.add(cardKeyUniqError);
                }
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            if (!errors.isEmpty()) {

                for (FieldError error : errors) {
                    result.addError(error);
                }
                return "admin/addCard";
            }
            else {
                card.setTypeCard(typeCardService.getTypeCardbyStatus("active"));
                cardService.saveCard(card);
                return "redirect:/admin/allCards";
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return "errorPage";
        }

    }

    @ModelAttribute("persons")
    public List<Persons> getAllUsers() {
        return personService.getUsers();
    }




}
