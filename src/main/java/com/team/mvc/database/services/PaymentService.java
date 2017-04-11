package com.team.mvc.database.services;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Events;
import com.team.mvc.database.repositories.CardBalanceRepository;
import com.team.mvc.database.repositories.EventsRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.sql.Timestamp;


public class PaymentService {
 /*   @Autowired
    CardBalanceRepository cardBalanceRepository;
    EventsRepository eventsRepository;
    public boolean paymentpossibility(long id, BigDecimal cost, double latitude, double longitude, Timestamp paymentTime, long busId) throws NotFoundException {
        if(cardBalanceRepository.getById(id).getBalance().compareTo(cost)<0) return false;
        else {cardBalanceRepository.getById(id).setBalance(cardBalanceRepository.getById(id).getBalance().subtract(cost)); Events events = new Events();
          eventsRepository.save(events);  return true;}
    }*/
}
