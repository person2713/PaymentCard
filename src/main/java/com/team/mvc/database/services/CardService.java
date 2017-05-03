package com.team.mvc.database.services;

import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.TypeCard;
import com.team.mvc.database.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CardService {

    @Autowired
    CardsRepository cardsRepository;

    @Autowired
    TypeCardService typeCardService;

    public List<Cards> getAll() {
        return cardsRepository.getAll();
    }

    public void saveCard(Cards cards) {
        cardsRepository.save(cards);
    }


}
