package com.team.mvc.controller;

/**

 */
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.services.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Controller
public class TestRestController {

    @Autowired
    BlackListService blackListService;


    @RequestMapping(value = "/blockCards/", method = RequestMethod.GET)
    @ResponseBody

    public List<Cards> listAllBlockCards() {
        List<Cards> cardsList = blackListService.getAllBlockCards();
        if (cardsList.isEmpty()) {
            return  cardsList;//You many decide to return HttpStatus.NOT_FOUND
        }
       

        return  cardsList;
    }
}

