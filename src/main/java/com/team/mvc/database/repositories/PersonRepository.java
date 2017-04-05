package com.team.mvc.database.repositories;


import com.team.mvc.database.entities.*;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PersonRepository extends AbstractRepository<Persons> {
    public PersonRepository() {
        super(Persons.class);
    }

    public Persons findByNickname(String nickname) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nickname", nickname));
        return (Persons) criteria.uniqueResult();
    }

    public void save(Persons persons) {
        super.save(persons);
    }

    public List<Cards> findCardsByNickname(String nickname) {

        Query query = getSession().createQuery("SELECT C FROM Cards  C WHERE C.person.nickname=:nickname");

        query.setParameter("nickname", nickname);
        return query.list();




     /*   Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nickname", nickname));
        return ((Persons) criteria.uniqueResult()).getCards();*/
    }

    public CardBalance findBalanceByNickname(String nickname) {

        Query query = getSession().createQuery("SELECT CB FROM CardBalance  CB WHERE CB.card.person.nickname=:nickname");

        query.setParameter("nickname", nickname);

        return (CardBalance) query.uniqueResult();




     /*   Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nickname", nickname));
        return ((Persons) criteria.uniqueResult()).getCards();*/
    }

    public List<BalanceHist> findBalanceHistByNickname(String nickname) {

        Query query = getSession().createQuery("SELECT BH FROM BalanceHist BH WHERE BH.card.person.nickname=:nickname");

        query.setParameter("nickname", nickname);

        return  query.list();
    }

    public List<Events> findEventsByNickname(String nickname) {

        Query query = getSession().createQuery("SELECT E FROM Events E WHERE E.card.person.nickname=:nickname");

        query.setParameter("nickname", nickname);

        return  query.list();
    }


}