package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.CardBalance;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Persons;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;


@Repository
@Transactional
public class CardBalanceRepository extends AbstractRepository<CardBalance> {
    public CardBalanceRepository() {
        super(CardBalance.class);
    }

    public void update() {
  /*  Session session = sessionFactory.openSession();
    Transaction tx = session.beginTransaction();

   String hqlUpdate = "UPDATE CardBalance set balance = :balance  WHERE balanceId = :balanceId";

    int updatedEntities = session.createQuery( hqlUpdate )
            .setLong( "balanceId", Long.parseLong("3") )
            .setParameter( "balance", BigDecimal.valueOf(1200) )
            .executeUpdate();
         tx.commit();
         session.close();*/



   /*    String UPDATE = "UPDATE CARD_BALANCE set BALANCE = 1300  WHERE BALANCE_ID = 3";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
        int result = sqlQuery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();*/

        String UPDATE = "update  COMPANIES CM SET CM.COMP_BALANCE =(SELECT(COUNTEVENTS*R.ROUTE_PRICE) AS TOTALSUM FROM  COMPANIES COM  INNER JOIN  ROUTES R  ON  R.COMPANY_ID = COM.COMPANY_ID INNER JOIN  BUSES B ON B.COMPANY_ID = COM.COMPANY_ID  INNER JOIN (SELECT  COUNT(E.EVENT_ID) AS COUNTEVENTS,E.BUS_ID FROM  EVENTS E GROUP BY  E.BUS_ID)E  ON  E.BUS_ID=B.BUS_ID WHERE COM.COMPANY_ID=46 GROUP BY  COM.COMPANY_ID, COUNTEVENTS*R.ROUTE_PRICE )where CM.COMPANY_ID = 46  ";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
        int result = sqlQuery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();

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
