package com.team.mvc.dao.interf;

import com.team.mvc.entity.RoutesEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface routersDao {
    RoutesEntity findById(int routeId);

    void saveRoute( RoutesEntity routesEntity);

    void deleteRoutebyRouteID(int routeId);

    List<RoutesEntity> findAllRoutes();

    List<RoutesEntity> findRouteByRouterNumber(String routeNumber);
    List<RoutesEntity> findRouteByCompanyID(long companyId); //add to entity

}
