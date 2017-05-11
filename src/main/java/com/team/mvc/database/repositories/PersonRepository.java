package com.team.mvc.database.repositories;


import com.team.mvc.database.entities.*;
import javassist.NotFoundException;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class PersonRepository  extends AbstractRepository{

    public PersonRepository() {
        super(Persons.class);
    }
    @Override
    public Persons getById(Long id) throws NotFoundException {
        return (Persons) super.getById(id);
    }

    public Persons findByNickname(String nickname) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nickname", nickname));
        return (Persons) criteria.uniqueResult();
    }

    public void save(Persons persons) {
        super.save(persons);
    }

    public Persons findByEmail(String email){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("email", email));
        return (Persons) criteria.uniqueResult();
    }


    public List<Cards> findCardsByNickname(String nickname) {
        String que = "SELECT * FROM CARDS  WHERE CARDS.PERSON_ID = (SELECT PERSONS.PERSON_ID FROM PERSONS   WHERE PERSONS.NICKNAME ="+"'"+nickname+"'"+")";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(que);
        List result = sqlQuery.list();




        return   result;





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

    @Override
    public List<Persons> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("personId"));
        return criteria.list();
    }

    public List<Persons> getPersonsWithCards(){
        Session session = sessionFactory.getCurrentSession();
        List<Persons> personsList = session.createCriteria(Persons.class).list();
        for (Persons persons: personsList) {
            Hibernate.initialize(persons.getCards());
        }
        return personsList;
    }
}