package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.TemporaryEvents;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**

 */
@Repository
@Transactional
public class TemporaryEventsRepository extends AbstractRepository<TemporaryEvents> {
    public TemporaryEventsRepository() {
        super(TemporaryEvents.class);
    }



    public List<TemporaryEvents> getAllTemporaryEvents(){
//        Query query = getSession().createQuery("SELECT C FROM Cards  C ");
//
////        query.setLong("typeCard", Long.parseLong("21")); WHERE C.typeCard=:typeCard
        Criteria criteria = createEntityCriteria();

        List<TemporaryEvents> temporaryEvents = criteria.list();

        return temporaryEvents;

      /*  String UPDATE = "SELECT * FROM TEMPORARY_EVENTS";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(UPDATE);
        List result = sqlQuery.list();
        System.out.println(result);
        session.getTransaction().commit();
        return result;*/
    }
    public void delAll(){

        String DEL = " DELETE  FROM TEMPORARY_EVENTS ";
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(DEL);
        int result = sqlQuery.executeUpdate();
        System.out.println(result);
        session.getTransaction().commit();
        session.close();
    }

}
