package com.team.mvc.controller.admincontrollers;


import com.team.mvc.controller.GetRole;
import com.team.mvc.database.services.CardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/allCards")
public class GetCards {

    @Autowired
    CardsService cardService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getCards(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("cards", cardService.getAll());
        return "admin/getCards";
    }


}
