package com.team.mvc.dao.interf;

import com.team.mvc.entity.BusesEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface busesDao {
    BusesEntity findById(short busId);
    List<BusesEntity> findByNumber(String busNumber);

    void saveBus( BusesEntity busesEntity);

    void deleteBusbyBusID(short busId);

    List<BusesEntity> findAllBus();


}
