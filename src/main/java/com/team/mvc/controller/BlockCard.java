package com.team.mvc.controller;

import com.team.mvc.database.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**

 */
@Controller
//@RequestMapping("/BlockCard")
public class BlockCard {
    @Autowired
    CardsRepository cardsRepository;

  //  @PutMapping("/admin/BlockCard/{cardId}")
    @RequestMapping(value = "/blockCardById/{cardId}", method = RequestMethod.GET)
    @ResponseBody

    public void    blockCardById(@PathVariable("cardId") Long cardId) {

        cardsRepository.blockCardById(cardId);}}


