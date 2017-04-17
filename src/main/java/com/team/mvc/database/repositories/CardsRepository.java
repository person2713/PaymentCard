package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardsRepository extends AbstractRepository<Cards> {
    public CardsRepository() {
        super(Cards.class);
    }
    @Autowired
    TypeCardRepository typeCardRepository;

    public List<Cards> getAllBlockCards(){
        Query query = getSession().createQuery("SELECT C.cardId FROM Cards  C WHERE C.typeCard=:typeCard ");
        query.setLong("typeCard", Long.parseLong("21"));
//        query.setLong("typeCard", Long.parseLong("21")); WHERE C.typeCard=:typeCard
        return query.list();}

    public Cards findByCardKey(long key) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cardKey", key));
        return (Cards) criteria.uniqueResult();
    }

    @Override
    public List<Cards> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("cardId"));
        return criteria.list();
    }
}
