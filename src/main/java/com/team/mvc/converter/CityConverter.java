package com.team.mvc.converter;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.services.CityService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CityConverter implements Converter<Object, Cities>{


    @Autowired
    CityService cityService;

    public Cities convert(Object element) {
        Long id = Long.parseLong((String) element);
        Cities city = null;
        try {
            city = cityService.findById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return city;
    }
}
