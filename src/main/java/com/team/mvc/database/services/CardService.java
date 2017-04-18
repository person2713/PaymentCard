package com.team.mvc.database.services;

import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardService {

    @Autowired
    CardsRepository cardsRepository;

    public List<Cards> getAll(){
        return cardsRepository.getAll();
    }
}
