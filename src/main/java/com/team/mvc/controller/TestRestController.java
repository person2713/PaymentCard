package com.team.mvc.controller;

/**

 */
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.services.BlackListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestRestController {

    @Autowired
    BlackListService blackListService;


    @RequestMapping(value = "/blockCards/", method = RequestMethod.GET)
    public ResponseEntity<List<Cards>> listAllBlockCards() {
        List<Cards> cardsList = blackListService.getAllBlockCards();
        if (cardsList.isEmpty()) {
            return new ResponseEntity<List<Cards>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Cards>>(cardsList, HttpStatus.OK);
    }
}

