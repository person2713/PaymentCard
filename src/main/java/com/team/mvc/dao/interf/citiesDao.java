package com.team.mvc.dao.interf;

import com.team.mvc.entity.Cities;

import java.util.List;

/**
 * Created by vit on 17.03.2017.
 */
public interface citiesDao  {
    Cities findById(long id);

    void saveCity( Cities citiesEntity);

    void deleteCitybyName(String city_name);

    List<Cities> findAllCities();

    Cities findCityByName(String city_name);
}
