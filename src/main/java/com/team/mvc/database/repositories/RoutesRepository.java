package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Routes;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
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

    public Routes findByRouteNumber(String routeNumber) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("routeNumber", routeNumber));
        return (Routes) criteria.uniqueResult();
    }

    @Override
    public void update(Routes route){

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Query query = session.createSQLQuery(
                    "update routes " +
                            "set route_number=:routeNumber, " +
                            "route_price=:routePrice, " +
                            "company_id=:companyId " +
                            "where route_id=:routeId");
            query.setParameter("routeNumber", route.getRouteNumber());
            query.setParameter("routePrice", route.getRoutePrice());
            query.setParameter("companyId", route.getCompanyId());
            query.setParameter("routeId", route.getRouteId());
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }

    }
}
