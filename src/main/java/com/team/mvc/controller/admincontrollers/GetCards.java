package com.team.mvc.controller.admincontrollers;


import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.TypeCard;
import com.team.mvc.database.services.CardsService;
import com.team.mvc.database.services.TypeCardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/allCards")
public class GetCards {

    @Autowired
    CardsService cardService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    TypeCardService typeCardService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCards(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("cards", cardService.getAll());
        return "admin/getCards";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUpdateCardForm(@PathVariable("id") long id, Model model) {

        try {
            Cards card = cardService.findById(id);
            model.addAttribute("edit", true);
            model.addAttribute("cardForm", card);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return "admin/addCard";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteCard(@PathVariable("id") long id) {
        cardService.delete(id);
        return "redirect:/admin/allCards";

    }

    @RequestMapping(value = "/editCard", method = RequestMethod.POST)
    public String saveOrUpdateDriver(@ModelAttribute("cardForm") @Validated Cards card, BindingResult result, Model model) {

        List<FieldError> errors = new ArrayList<>();

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
            model.addAttribute("edit", true);
            return "admin/addCard";
        }
        else {
            cardService.update(card);
            return "redirect:/admin/allCards";
        }
    }

    @ModelAttribute("typeCard")
    public List<TypeCard> getAllCompanies() {
        return typeCardService.getAll();
    }

}
