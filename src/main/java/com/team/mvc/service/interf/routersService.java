package com.team.mvc.service.interf;

import com.team.mvc.entity.RoutesEntity;

import java.util.List;

/**
 * Created by vit on 22.03.2017.
 */
public interface routersService {
    RoutesEntity findById(int routeId);

    void saveRoute( RoutesEntity routesEntity);

    void deleteRoutebyRouteID(int routeId);

    List<RoutesEntity> findAllRoutes();

    List<RoutesEntity> findRouteByRouterNumber(String routeNumber);
    List<RoutesEntity> findRouteByCompanyID(long companyId);
}
