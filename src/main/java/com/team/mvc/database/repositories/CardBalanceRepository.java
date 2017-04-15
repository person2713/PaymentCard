package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.CardBalance;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Persons;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CardBalanceRepository extends AbstractRepository<CardBalance> {
    public CardBalanceRepository() {
        super(CardBalance.class);
    }

    public CardBalance findByCard(Cards card) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("card", card));
        return (CardBalance) criteria.uniqueResult();
    }

    public void save(CardBalance cardBalance) {
        super.save(cardBalance);
    }

    @Override
    public List<CardBalance> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("balanceId"));
        return criteria.list();
    }

}
