package com.team.mvc.database.services;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.repositories.CitiesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    public Cities findById(long id) throws NotFoundException {
        return citiesRepository.getById(id);
    }

    public List<String> stringCities(){
        List<String> list = new ArrayList<>();
        for (Cities city: citiesRepository.getAll()) {
            list.add(city.getCityName());
        }
        return list;
    }
}
