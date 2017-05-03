package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.*;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardsRepository extends AbstractRepository<Cards> {
    public CardsRepository() {
        super(Cards.class);
    }

//    public void update(int cardId, String cardName, Persons person, long cardKey, TypeCard typeCard,
//                       CardBalance cardBalance, List<BalanceHist> balanceHists, List<Events> events) {
//        Session session = getSession();
//        Cards card = session.load(Cards.class, (long)cardId);
//        card.setCardName(cardName);
//        card.setCardKey(cardKey);
//        card.setTypeCard(typeCard);
//        card.setCardBalance(cardBalance);
//        card.setBalanceHists(balanceHists);
//        card.setEvents(events);
//        session.update(card);
//    }
}
