package com.team.mvc.converter;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.services.BusesService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BusesConverter implements Converter<Object, Buses> {

    @Autowired
    BusesService busesService;

    public Buses convert(Object element) {
        Long id = Long.parseLong((String) element);
        Buses bus = null;
        try {
            bus = busesService.findById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return bus;
    }
}
