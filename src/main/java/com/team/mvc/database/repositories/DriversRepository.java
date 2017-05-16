package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Persons;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Driver;
import java.util.List;


@Repository
@Transactional
public class DriversRepository extends AbstractRepository<Drivers> {
    public DriversRepository() {
        super(Drivers.class);
    }

    public void save(Drivers driver) {
        super.save(driver);
    }

    public Drivers getByPerson(Persons person) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("person", person));
        return (Drivers) criteria.uniqueResult();
    }
    @Override
    public List<Drivers> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("driverId"));
        return criteria.list();
    }

    public Drivers findByNickname(String nickname) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery(String.format("select * from drivers d left join persons p on d.person_id = p.person_id where p.nickname= :nickname"))
                .addEntity(Drivers.class).setParameter("nickname", nickname);
        return (Drivers)query.uniqueResult();
    }

    @Override
    public void update(Drivers driver){
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery(String.format("update drivers set company_id=:companyId where driver_id=:driverId"));
        query.setParameter("companyId", driver.getCompanyId());
        query.setParameter("driverId", driver.getDriverId());
        query.executeUpdate();

    }
}
