package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Routes;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class BusesRepository extends AbstractRepository<Buses> {
    public BusesRepository() {
        super(Buses.class);
    }

    public void save(Buses bus) {
        super.save(bus);
    }

    public List<Buses> findByCompanyId(long companyId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("companyId", companyId));
        return criteria.list();
    }

    @Override
    public List<Buses> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("busId"));
        return criteria.list();
    }
}
