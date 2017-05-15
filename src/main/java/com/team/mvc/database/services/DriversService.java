package com.team.mvc.database.services;

import com.team.mvc.database.entities.CarAssign;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.repositories.CarAssignRepository;
import com.team.mvc.database.repositories.DriversRepository;
import com.team.mvc.database.repositories.PersonRepository;
import com.team.mvc.database.repositories.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class DriversService {

    @Autowired
    DriversRepository driversRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    CarAssignRepository carAssignRepository;

    public Drivers findById(long id) throws NotFoundException {
        return driversRepository.getById(id);
    }

    public Drivers findByPerson(Persons person) throws NotFoundException {
        return driversRepository.getByPerson(person);
    }

    public void save(Drivers driver) {
        driver.getPerson().setRole(roleRepository.findByType("DRIVER"));
        personRepository.save(driver.getPerson());
        Long personId = personRepository.findByNickname(driver.getPerson().getNickname()).getPersonId();
        driver.getPerson().setPersonId(personId);
        driversRepository.save(driver);
    }

    public List<Drivers> getAll() {
        return driversRepository.getAll();
    }

    public void delete(Long id) {
        try {
            driversRepository.delete(driversRepository.getById(id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isDriverNicknameUnique(Long id, String nickname) {
        Drivers driver = findByNickname(nickname);
        return (driver == null || ((id != null) && (driver.getDriverId().equals(id))));
    }

    public Drivers findByNickname(String nickname) {
        return driversRepository.findByNickname(nickname);
    }

    public void update(Drivers driver) {
        driver.getPerson().setRole(roleRepository.findByType("DRIVER"));
        personRepository.update(driver.getPerson());
        Set<CarAssign> carAssigns = new HashSet<> (carAssignRepository.getAllForDriver(driver.getDriverId()));
        driver.setCarAssigns(carAssigns);
        driversRepository.update(driver);
    }
}
