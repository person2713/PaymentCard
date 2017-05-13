package com.team.mvc.converter;


import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.services.RoutesService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RouteConverter implements Converter<Object, Routes> {

    @Autowired
    RoutesService routesService;

    public Routes convert(Object element) {
        Long id = Long.parseLong((String) element);
        Routes route = null;
        try {
            route = routesService.findById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return route;
    }
}
