package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Routes;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class RoutesRepository extends AbstractRepository<Routes> {
    public RoutesRepository() {
        super(Routes.class);
    }

    public void save(Routes route) {
        super.save(route);
    }

    public List<Routes> findByCompanyId(long companyId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("companyId", companyId));
        return criteria.list();
    }

    @Override
    public List<Routes> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("routeId"));
        return criteria.list();
    }
}
