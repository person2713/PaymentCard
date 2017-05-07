package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Persons;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
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
}
