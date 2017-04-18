package com.team.mvc.database.services;

import com.team.mvc.database.entities.*;
import com.team.mvc.database.repositories.CitiesRepository;
import com.team.mvc.database.repositories.PersonRepository;

import com.team.mvc.database.repositories.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CitiesRepository citiesRepository;

    @Autowired
    RoleRepository roleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public Persons findById(int id) throws NotFoundException {
        return personRepository.getById(id);
    }

    public Persons findByNickname(String nickname) {
        return personRepository.findByNickname(nickname);
    }

    public void savePerson(Persons persons){
        persons.setPassword(passwordEncoder.encode(persons.getPassword()));
        personRepository.save(persons);
    }

    public List<Persons> getAllUser(){
        return personRepository.getAll();
    }

    public List<Persons> getUsers(){
        List<Persons> personList = new ArrayList<>();
        for (Persons person:personRepository.getAll()) {
            if(person.getRole().getRoleType().equals("USER"))
                personList.add(person);
        }
        return personList;
    }


    public List<Persons> getOwners(){
        List<Persons> personList = new ArrayList<>();
        for (Persons person:personRepository.getAll()) {
            if(person.getRole().getRoleType().equals("OWNER"))
                personList.add(person);
        }
        return personList;
    }


    public List<Persons> getDrivers(){
        List<Persons> personList = new ArrayList<>();
        for (Persons person:personRepository.getAll()) {
            if(person.getRole().getRoleType().equals("DRIVER"))
                personList.add(person);
        }
        return personList;
    }

    public void deleteByNickName(String nickname){
        personRepository.deleteByNickName(nickname);
    }


    public boolean isPersonsNicknameUnique(Integer id, String nickname) {
        Persons persons = findByNickname(nickname);
        return ( persons == null || ((id != null) && (persons.getPersonId() == id)));

    }

    public List<Cards> findCradsByNickname(String nickname) {return personRepository.findCardsByNickname(nickname);}
    public CardBalance findBalanceByNickname(String nickname) {return personRepository.findBalanceByNickname(nickname);}
    public List<BalanceHist> findBalanceHistByNickname(String nickname) {return personRepository.findBalanceHistByNickname(nickname);}
    public List<Events> findEventsByNickname(String nickname) {return personRepository.findEventsByNickname(nickname);}

    public void update(int id, String nickname, String firstName, String lastName, String mobileNumber,
                       String email, String stringCity, String password){
        Cities city =  citiesRepository.findByName(stringCity);
        personRepository.update(id, nickname, firstName, lastName, mobileNumber, email, city, passwordEncoder.encode(password));
    }
}
