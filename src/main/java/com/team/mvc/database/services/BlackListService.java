package com.team.mvc.database.services;

import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.repositories.CardsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**

 */
@Service("blackListService")
@Transactional
public class BlackListService {
    @Autowired
    CardsRepository cardsRepository;

    public List<Cards> getAllBlockCards() {
        return cardsRepository.getAllBlockCards();
    }

    public List<Long> getAllBlockCardKeys() {
        List<Cards> cards = cardsRepository.getAllBlockCards();
        List<Long> result = new ArrayList<>(cards.size());
        for (Cards card :
                cards) {
            result.add(card.getCardKey());
        }
        return result;
    }
}
