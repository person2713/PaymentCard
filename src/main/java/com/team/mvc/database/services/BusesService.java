package com.team.mvc.database.services;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.repositories.BusesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BusesService {
    @Autowired
    BusesRepository busesRepository;

    public Buses findById(int id) throws NotFoundException {
        return busesRepository.getById((long) id);
    }

    public Buses findById(long id) throws NotFoundException {
        return busesRepository.getById(id);
    }

    public List<Buses> findByCompanyId(long companyId) {
        return busesRepository.findByCompanyId(companyId);
    }

    public void save(Buses bus) {
        busesRepository.save(bus);
    }

    public List<Buses> getAll() {
        return busesRepository.getAll();
    }
}
