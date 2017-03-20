package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.busesDao;
import com.team.mvc.entity.BusesEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class busesDaoImpl  extends AbstractDao<Short,BusesEntity> implements busesDao {
    @Override
    public BusesEntity findById(short busId) {
        return null;
    }

    @Override
    public BusesEntity findByNumber(String busNumber) {
        return null;
    }

    @Override
    public void saveBus(BusesEntity busesEntity) {

    }

    @Override
    public void deleteBusbyBusID(short busId) {

    }

    @Override
    public List<BusesEntity> findAllBus() {
        return null;
    }
}
