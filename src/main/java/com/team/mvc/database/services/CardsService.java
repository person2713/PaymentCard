package com.team.mvc.database.services;

import com.team.mvc.database.entities.BalanceHist;
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

    public Cards findById(long id) throws NotFoundException {
        return cardsRepository.getById(id);
    }

    public Cards findByCardKey(long cardKey) throws NotFoundException {
        return cardsRepository.findByCardKey(cardKey);
    }

    public boolean isCardNameUnique(Long id, String cardName) {
        Cards card = findByCardName(cardName);
        return (card == null || ((id != null) && (card.getCardId().equals(id))));
    }

    public boolean isCardKeyUnique(Long id, long cardkey) throws NotFoundException {
        Cards card = findByCardKey(cardkey);
        return (card == null || ((id != null) && (card.getCardId().equals(id))));
    }

    public Cards findById(int id) {
        return cardsRepository.findById(id);
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
        cardBalanceRepository.update(card.getCardBalance());
        typeCardRepository.update(card.getTypeCard());
        Set<BalanceHist> balanceHists = new HashSet<>(balanceHistRepository.getAllHistForCard(card.getCardId()));
        Set<Events> events = new HashSet<>(eventsRepository.getAllEventsForCard(card.getCardId()));
        card.setBalanceHists(balanceHists);
        card.setEvents(events);
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
