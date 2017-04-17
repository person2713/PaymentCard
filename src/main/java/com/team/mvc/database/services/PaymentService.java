package com.team.mvc.database.services;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.CardBalance;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Events;
import com.team.mvc.database.repositories.EventsRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Service
@Transactional
public class PaymentService {
    @Autowired
    CardBalanceService cardBalanceService;
    @Autowired
    EventsRepository eventsRepository;

    /**
     * Выполняет попытку снятия средств с карты
     *
     * @param card        Карта, с которой требуется снять средства
     * @param cost        сумма снятия
     * @param latitude    координаты(широта)
     * @param longitude   координаты(долгота
     * @param paymentTime время платежа
     * @param bus         автобус, с котрого произведен платеж
     * @return true, в случае успешного снятия средств, иначе false
     * @throws NotFoundException
     */
    public boolean paymentPossibility(Cards card, BigDecimal cost, double latitude, double longitude, Timestamp paymentTime, Buses bus) throws NotFoundException {
        CardBalance cardBalance = cardBalanceService.findByCard(card);
        if (cardBalance.getBalance().compareTo(cost) < 0) return false;

        cardBalance.setBalance(cardBalance.getBalance().subtract(cost));
        Events events = new Events();
        events.setLatitude(latitude);
        events.setLongitude(longitude);
        events.setBus(bus);
        events.setCard(card);
        eventsRepository.save(events);
        return true;
    }
}
