package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.*;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
@Transactional
public class CardsRepository extends AbstractRepository<Cards> {
    public CardsRepository() {
        super(Cards.class);
    }
    @Autowired
    TypeCardRepository typeCardRepository;

    @Autowired
    public SessionFactory sessionFactoryZ;

    @Override
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Cards> getAllBlockCards(){
//        Query query = getSession().createQuery("SELECT C FROM Cards  C ");
//
////        query.setLong("typeCard", Long.parseLong("21")); WHERE C.typeCard=:typeCard
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.in("typeCard", typeCardRepository.getByStatus("block")));
        List<Cards> cardss=criteria.list();
        return cardss;
    }

    public void blockCardById(long cardId){
     /*  Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE Cards C SET C.typeCard =:typeCard WHERE C.cardId=:cardId");

        query.setLong("cardId",cardId);
        query.setLong("typeCard",Long.parseLong("21"));
        int result = query.executeUpdate();
        session.getTransaction().commit();*/

     /*   String UPDATE = "UPDATE Cards CM SET CM.TYPE_ID =21 WHERE CM.card_Id=" + cardId ;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
        int result = sqlQuery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();*/
        String UPDATE = "UPDATE CARDS  SET CARDS.TYPE_ID =21 WHERE CARDS.CARD_ID="+cardId;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
        int result = sqlQuery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();
        }




    public Cards findByCardName(String cardName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cardName", cardName));
        return (Cards) criteria.uniqueResult();
    }
    public Cards findById(int id) {
        String que = "SELECT * FROM CARDS  WHERE CARDS.CARD_ID="+id;

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(que).addEntity(Cards.class);

        return  (Cards) sqlQuery.uniqueResult();
    }


    public void updateName(long id, String name) {
        String UPDATE = "UPDATE CARDS  SET CARD_NAME ="+"'"+name+"'"+"WHERE CARDS.CARD_ID="+id;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
        int result = sqlQuery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();
    }

    public Cards findByCardKey(long key) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cardId", key));
        return (Cards) criteria.uniqueResult();
    }

    public void updateMoney(long id, BigDecimal money) {

        String UPDATE = "UPDATE CARD_BALANCE  SET CARD_BALANCE.BALANCE =CARD_BALANCE.BALANCE+"+money+" WHERE CARD_BALANCE.CARD_ID="+id;
        Session session = sessionFactory.openSession();
        try {

            session.getTransaction().begin();
            session.createSQLQuery(UPDATE).executeUpdate();
            session.getTransaction().commit();
            session.close();
        }
        catch (HibernateException erro){
            System.out.println(erro);
            session.getTransaction().rollback();
            session.close();
        }

//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
//        int result = sqlQuery.executeUpdate();
//        System.out.println(result);
//        session.getTransaction().commit();
    }
    @Override
    public List<Cards> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.asc("cardId"));
        return criteria.list();
//        Session session = sessionFactory.openSession();
//        Query query = session.createSQLQuery("select * from cards");
//        return new ArrayList<Cards> (query.list());
    }


    @Override
    public void update(Cards card){
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery(String.format("update cards set person_id=:personId where card_id=:cardId"));
        query.setParameter("personId", card.getPersonId());
        query.setParameter("cardId", card.getCardId());
        query.executeUpdate();
    }
}
