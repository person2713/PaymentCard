package com.team.mvc.database.services;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.repositories.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CityService {

    @Autowired
    CitiesRepository citiesRepository;

    public Cities findByName(String cityName) {
        return citiesRepository.findByName(cityName);
    }

    public List<Cities> getAll(){
        return citiesRepository.getAll();
    }
}
