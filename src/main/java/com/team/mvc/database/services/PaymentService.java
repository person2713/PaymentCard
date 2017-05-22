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
import java.util.List;

@Service
@Transactional
public class PaymentService {
    @Autowired
    CardsService cardsService;
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    CardBalanceService cardBalanceService;

    /**
     * Выполняет попытку снятия средств с карты
     *
     * @param cardId        Карта, с которой требуется снять средства
     * @param cost        сумма снятия
     * @param latitude    координаты(широта)
     * @param longitude   координаты(долгота
     * @param busId         автобус, с котрого произведен платеж
     * @return true, в случае успешного снятия средств, иначе false
     * @throws NotFoundException
     */
    public boolean paymentPossibility(long cardId, BigDecimal cost, double latitude, double longitude, long busId) throws NotFoundException {
        Cards card=cardsService.findById(cardId);
        CardBalance cardBalance =card.getCardBalance();
        if (cardBalance.getBalance().compareTo(cost) < 0) return false;

        cardBalance.setBalance(cardBalance.getBalance().subtract(cost));
        Events events = new Events();
        events.setLatitude(latitude);
        events.setLongitude(longitude);
        events.setBusId(busId);
        events.setCardId(card.getCardId());
        Timestamp time=new Timestamp(System.currentTimeMillis());
        time.setTime(1000*(long)Math.floor(time.getTime()/ 1000));//отбрасывание миллисекунд
        events.setPaymentTime(time);
        eventsRepository.save(events);
        return true;
    }


}
