package com.team.mvc.service.interf;

import com.team.mvc.entity.BusesEntity;

import java.util.List;

/**
 * Created by vit on 22.03.2017.
 */
public interface busesService {
    BusesEntity findById(short busId);
    List<BusesEntity> findByNumber(String busNumber);
    void updateBuses(BusesEntity busesEntity);

    void saveBus( BusesEntity busesEntity);

    void deleteBusbyBusID(short busId);

    List<BusesEntity> findAllBus();
}
