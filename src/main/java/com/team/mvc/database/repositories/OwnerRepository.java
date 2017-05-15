package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.BalanceHist;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Owners;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OwnerRepository extends AbstractRepository<Owners> {
    public OwnerRepository() {
        super(Owners.class);
    }

//    public Owners findByNickname(String nickname) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("getPerson().nickname", nickname));
//        return (Owners) criteria.uniqueResult();
//    }

    public Owners findByNickname(String nickname) {
        String query = "SELECT * FROM PERSONS  WHERE PERSONS.NICKNAME='" + nickname + "'";

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery sqlQuery = session.createSQLQuery(query).addEntity(Owners.class);
        return (Owners) sqlQuery.uniqueResult();
    }

}
