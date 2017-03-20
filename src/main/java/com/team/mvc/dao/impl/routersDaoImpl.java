package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.routersDao;
import com.team.mvc.entity.RoutesEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class routersDaoImpl extends AbstractDao<Integer,RoutesEntity> implements routersDao {
    @Override
    public RoutesEntity findById(int routeId) {
        return null;
    }

    @Override
    public void saveRoute(RoutesEntity routesEntity) {
        persist(routesEntity);
    }

    @Override
    public void deleteRoutebyRouteID(int routeId) {
        Query query = getSession().createSQLQuery("delete from ROUTES where ROUTE_ID = :routeId");
        query.setParameter("routeId", routeId);
        query.executeUpdate();
    }

    @Override
    public List<RoutesEntity> findAllRoutes() {
        Criteria criteria = createEntityCriteria();
        return (List<RoutesEntity>) criteria.list();
    }

    @Override
    public RoutesEntity findRouteByRouterNumber(String routeNumber) {
        return null;
    }

    @Override
    public RoutesEntity findRouteByCompanyID(long companyId) {
        return null;
    }

    @Override
    public RoutesEntity findRouteByRouteID(int routeId) {
        return null;
    }
}
