package com.team.mvc.database.repositories;


import com.team.mvc.database.entities.*;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class PersonRepository {

    @Autowired
    private SessionFactory sessionFactory;


    protected Criteria createEntityCriteria() {

        return getSession().createCriteria(Persons.class);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Persons getById(Long id) throws NotFoundException {
        return (Persons) getSession().get(Persons.class, id);
    }


    public List<Persons> getAll() {
        return getSession().createCriteria(Persons.class).list();
    }

    public void save(Persons entity) {
        getSession().persist(entity);

    }

    public void delete(Persons entity) {

        getSession().delete(entity);
    }


    public Persons findByNickname(String nickname) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("nickname", nickname));
        return (Persons) criteria.uniqueResult();
    }

//    public void save(Persons persons) {
//        super.save(persons);
//    }


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
/*
    @Override
    public List<Persons> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("personId"));
        return criteria.list();
    }*/

    public void deleteByNickName(String nickname){
        delete(this.findByNickname(nickname));
    }



    public void update(int personId, String nickname, String firstName, String lastName, String mobileNumber,
                       String email, Cities city, Rollers role, String password) {
        Session session = getSession();
        Persons persons = session.load(Persons.class, personId);
        persons.setNickname(nickname);
        persons.setFirstName(firstName);
        persons.setLastName(lastName);
        persons.setMobileNumber(mobileNumber);
        persons.setEmail(email);
        persons.setCity(city);
        persons.setRole(role);
        persons.setPassword(password);
        session.update(persons);
    }

}