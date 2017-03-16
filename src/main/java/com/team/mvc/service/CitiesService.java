package com.team.mvc.service;

import com.team.mvc.dao.CitiesDaoImpl;
import com.team.mvc.entity.CitiesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by vit on 16.03.2017.
 */
@Service("CitiesService")
@Transactional(readOnly = true)
public class CitiesService {
    @Autowired
    CitiesDaoImpl citiesDao;
    @Transactional(readOnly = false)
    /**
     * Get Customer
     *
     * @param cityName String CitiesEntity cityName
     */

    public CitiesEntity getCityByName(String cityName) {
        return getCitiesDao().getCitiesEntity(cityName);
    }
    /**
     * Get Customer DAO
     *
     * @return customerDAO - Customer DAO
     */
    @Transactional(readOnly = false)
    public CitiesDaoImpl getCitiesDao() {
        return citiesDao;
    }
}
