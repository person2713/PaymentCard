package com.team.mvc.service.interf;

import com.team.mvc.entity.CitiesEntity;

import java.util.List;

/**
 * Created by vit on 17.03.2017.
 */
public interface citiesService {

    CitiesEntity findById(long id);

    void saveCity(CitiesEntity citiesEntity);

    void updateCity(CitiesEntity citiesEntity);

    void deleteCityByName(String city_name);

    List<CitiesEntity> findAllCities();

    CitiesEntity findCityByName(String city_name);

    boolean isCityNameUnique(long id, String city_name);

}
