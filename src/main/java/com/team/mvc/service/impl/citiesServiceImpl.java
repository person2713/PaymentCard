package com.team.mvc.service.impl;

import com.team.mvc.dao.interf.citiesDao;
import com.team.mvc.entity.CitiesEntity;

import java.util.List;

/**
 * Created by vit on 17.03.2017.
 */


import java.util.Objects;

import com.team.mvc.service.interf.citiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service("citiesService")
@Transactional
public class citiesServiceImpl implements citiesService {

    @Autowired
    private citiesDao dao;
    @Override
    public CitiesEntity findById(long id) {
        return dao.findById(id);
    }

    @Override
    public void saveCity(CitiesEntity citiesEntity) {
        dao.saveCity(citiesEntity);

    }

    @Override
    public void updateCity(CitiesEntity citiesEntity) {

        CitiesEntity entity = dao.findById(citiesEntity.getCityId());
        if(entity!=null){
            entity.setCityName(citiesEntity.getCityName());

        }

    }

    @Override
    public void deleteCityByName(String city_name) {
            dao.deleteCitybyName(city_name);

    }

    @Override
    public List<CitiesEntity> findAllCities() {
        return dao.findAllCities();
    }

    @Override
    public CitiesEntity findCityByName(String city_name) {
        return dao.findCityByName(city_name);
    }

    @Override
    public boolean isCityNameUnique(long id, String city_name) {
        CitiesEntity citiesEntity = findCityByName(city_name);
        return ( citiesEntity == null || ((Objects.nonNull(id) ) && (citiesEntity.getCityId() == id)));
    }
}
