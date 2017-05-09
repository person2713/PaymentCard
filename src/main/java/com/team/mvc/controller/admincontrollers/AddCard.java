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
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

@Controller
@RequestMapping("/admin/addCard")
public class AddCard {

    @Autowired
    PersonService personService;

    @Autowired
    CardsService cardService;

    @Autowired
    TypeCardService  typeCardService;

    @Autowired
    CardBalanceService cardBalanceService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddCard(ModelMap model) {
        Cards card = new Cards();
        CardBalance cardBalance = new CardBalance();
        model.addAttribute("cardForm", card);
        model.addAttribute("cardBalance", cardBalance);
        return "/admin/addCard";
    }

    @RequestMapping(value = "/newCard", method = RequestMethod.POST)
    public String saveCard(@Valid @ModelAttribute("cardForm") Cards card, @RequestParam("balance") String balance,
                           BindingResult result, ModelMap model) {
        card.setTypeCard(typeCardService.getTypeCardbyStatus("active"));
        String cardName = card.getCardName();
        cardService.saveCard(card);
        CardBalance cardBalance = new CardBalance();
        cardBalance.setBalance(BigDecimal.valueOf(Double.valueOf(balance)));
        Cards cardss = cardService.findByCardName(cardName);
        cardBalance.setCard(cardss);
        cardBalanceService.save(cardBalance);
        return "success";
    }


    @ModelAttribute("persons")
    public List<Persons> initializeCities() {
        return personService.getAllUser();
    }




}
