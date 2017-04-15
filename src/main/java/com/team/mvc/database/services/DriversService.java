package com.team.mvc.database.services;

import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.repositories.DriversRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DriversService {

    @Autowired
    DriversRepository driversRepository;

    public Drivers findById(long id) throws NotFoundException {
        return driversRepository.getById(id);
    }

    public Drivers findByPerson(Persons person) throws NotFoundException {
        return driversRepository.getByPerson(person);
    }

    public void save(Drivers driver){
        driversRepository.save(driver);
    }

    public List<Drivers> getAll(){
        return driversRepository.getAll();
    }
}
