package com.team.mvc.database.services;

import com.team.mvc.database.entities.BalanceHist;
import com.team.mvc.database.entities.CardBalance;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Events;
import com.team.mvc.database.repositories.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CardsService {

    @Autowired
    CardsRepository cardsRepository;

    @Autowired
    CardBalanceRepository cardBalanceRepository;

    @Autowired
    BalanceHistRepository balanceHistRepository;

    @Autowired
    EventsRepository eventsRepository;

    @Autowired
    TypeCardRepository typeCardRepository;

    public Cards findById(long id)  {
        try {
            return cardsRepository.getById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Cards findByCardKey(long cardKey)  {
        try {
            return cardsRepository.findByCardKey(cardKey);
        }
        catch (NullPointerException e){
            return null;
        }
    }

    public boolean isCardNameUnique(Long id, String cardName) {
        Cards card = findByCardName(cardName);
        return (card == null || ((id != null) && (card.getCardId().equals(id))));
    }

    public boolean isCardKeyUnique(Long id, long cardKey) throws NotFoundException {
        Cards card = findByCardKey(cardKey);
        return (card == null || ((id != null) && (card.getCardId().equals(id))));
    }


    public void saveOrUpdate(Cards cards) throws NotFoundException {

        if (findById(cards.getCardId()) == null) {
            cardsRepository.save(cards);
        } else {
            cardsRepository.update(cards);
        }

    }

    public void updateName(long id, String name) {

        cardsRepository.updateName(id, name);

    }

    public void updateMoney(long id, BigDecimal money) {
        cardsRepository.updateMoney(id, money);
    }

    public void saveCard(Cards card) {
        cardsRepository.save(card);
    }

    public void update(Cards card) {
        card.getCardBalance().setCard(card);
        cardsRepository.update(card);
    }

    public List<Cards> getAll() {
        return cardsRepository.getAll();
    }


    public Cards findByCardName(String cardName) {
        return cardsRepository.findByCardName(cardName);
    }


    public void blockCardById(long cardId) {
        cardsRepository.blockCardById(cardId);
    }

    public void delete(Long id) {
        try {
            cardsRepository.delete(cardsRepository.getById(id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
