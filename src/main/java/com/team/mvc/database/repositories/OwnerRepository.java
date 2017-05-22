package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Owners;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class OwnerRepository extends AbstractRepository<Owners> {
    public OwnerRepository() {
        super(Owners.class);
    }

    public Owners findByNickname(String nickname) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery("select * from owners o left join persons p on o.person_id = p.person_id where p.nickname= :nickname")
                .addEntity(Owners.class).setParameter("nickname", nickname);
        return (Owners)query.uniqueResult();
    }

    @Override
    public void delete(Owners owner){
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query1 = session.createSQLQuery(
                "delete from owners " +
                        "where owner_id=:ownerId");
        query1.setParameter("ownerId", owner.getOwnerId());
        query1.executeUpdate();

        Query query2 = session.createSQLQuery(
                "delete from persons " +
                        "where person_id=:personId");
        query2.setParameter("personId", owner.getPerson().getPersonId());
        query2.executeUpdate();

        session.getTransaction().commit();
    }

}
