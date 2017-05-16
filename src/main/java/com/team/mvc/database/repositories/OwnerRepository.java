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

}
