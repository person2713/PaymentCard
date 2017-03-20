package com.team.mvc.dao.interf;

import com.team.mvc.entity.CitiesEntity;

import java.util.List;

/**
 * Created by vit on 17.03.2017.
 */
public interface citiesDao  {
    CitiesEntity findById(long id);

    void saveCity( CitiesEntity citiesEntity);

    void deleteCitybyName(String city_name);

    List<CitiesEntity> findAllCities();

    CitiesEntity findCityByName(String city_name);
}
