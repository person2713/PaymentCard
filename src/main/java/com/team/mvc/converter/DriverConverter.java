package com.team.mvc.converter;


import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.services.BusesService;
import com.team.mvc.database.services.DriversService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DriverConverter implements Converter<Object, Drivers> {

    @Autowired
    DriversService driversService;

    public Drivers convert(Object element) {
        Long id = Long.parseLong((String) element);
        Drivers driver = null;
        try {
            driver = driversService.findById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return driver;
    }
}
