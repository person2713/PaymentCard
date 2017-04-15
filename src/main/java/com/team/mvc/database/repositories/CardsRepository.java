package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.*;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardsRepository extends AbstractRepository<Cards> {
    public CardsRepository() {
        super(Cards.class);
    }
    public List<Cards> getAllBlockCards(){
        Query query = getSession().createQuery("SELECT C.cardId FROM Cards  C WHERE C.typeCard=:typeCard ");
        query.setLong("typeCard", Long.parseLong("21"));
//        query.setLong("typeCard", Long.parseLong("21")); WHERE C.typeCard=:typeCard
        return query.list();

    }
}
