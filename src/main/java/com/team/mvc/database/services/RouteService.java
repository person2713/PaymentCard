package com.team.mvc.database.services;

import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.repositories.RoutesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RouteService {


    @Autowired
    RoutesRepository routesRepository;

    public List<Routes> getAll(){
        return routesRepository.getAll();
    }

    public void save(Routes route) {
        routesRepository.save(route);
    }
}
