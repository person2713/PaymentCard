package com.team.mvc.database.services;

import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.repositories.RoutesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoutesService {

    @Autowired
    RoutesRepository routesRepository;

    public Routes findById(int id) throws NotFoundException {
        return routesRepository.getById((long) id);
    }

    public Routes findById(long id) throws NotFoundException {
        return routesRepository.getById(id);
    }

    public List<Routes> findByCompanyId(long companyId) {
        return routesRepository.findByCompanyId(companyId);
    }

    public void save(Routes route) {
        routesRepository.save(route);
    }

    public List<Routes> getAll() {
        return routesRepository.getAll();
    }
}
