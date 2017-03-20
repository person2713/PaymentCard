package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.routersDao;
import com.team.mvc.entity.RoutesEntity;

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

    }

    @Override
    public void deleteRoutebyRouteID(int routeId) {

    }

    @Override
    public List<RoutesEntity> findAllRoutes() {
        return null;
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
