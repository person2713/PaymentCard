package com.team.mvc.database.services;

import com.team.mvc.database.entities.CardBalance;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.repositories.CardBalanceRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CardBalanceService {

    @Autowired
    CardBalanceRepository cardBalanceRepository;

    public CardBalance findById(long id) throws NotFoundException {
        return cardBalanceRepository.getById(id);
    }

    public CardBalance findByCard(Cards card) throws NotFoundException {
        return cardBalanceRepository.findByCard(card);
    }

    public void save(CardBalance driver){
        cardBalanceRepository.save(driver);
    }

    public List<CardBalance> getAll(){
        return cardBalanceRepository.getAll();
    }
}
