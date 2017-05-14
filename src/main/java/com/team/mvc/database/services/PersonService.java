package com.team.mvc.database.services;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.*;
import com.team.mvc.database.repositories.CardsRepository;
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
    @Autowired
    CardsRepository cardsRepository;




    public Persons findByEmail(String email){return personRepository.findByEmail(email);}

    public Persons findById(Long id) throws NotFoundException {
        return personRepository.getById(id);
    }

    public Persons findByNickname(String nickname) {
        return personRepository.findByNickname(nickname);
    }

    public void savePerson(Persons persons) {
        persons.setPassword(passwordEncoder.encode(persons.getPassword()));
        personRepository.save(persons);
    }


    public List<Persons> getUsers() {
        List<Persons> personList = new ArrayList<>();
        for (Persons person : personRepository.getAll()) {
            if (person.getRole().getRoleType().equals("USER"))
                personList.add(person);
        }
        return personList;
    }

    public void delete(Long id) {
        try {
            personRepository.delete(personRepository.getById(id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }


//
//    public List<Persons> getOwners() {
//        List<Persons> personList = new ArrayList<>();
//        for (Persons person : personRepository.getAll()) {
//            if (person.getRole().getRoleType().equals("OWNER"))
//                personList.add(person);
//        }
//        return personList;
//    }
//
//
//    public List<Persons> getDrivers() {
//        List<Persons> personList = new ArrayList<>();
//        for (Persons person : personRepository.getAll()) {
//            if (person.getRole().getRoleType().equals("DRIVER"))
//                personList.add(person);
//        }
//        return personList;
//    }



    public boolean isPersonsNicknameUnique(Long id, String nickname) {
        Persons persons = findByNickname(nickname);
        return (persons == null || ((id != null) && (persons.getPersonId() == id)));

    }


    public List<String> stringPersons() {
        List<String> list = new ArrayList<>();
        for (Persons person : personRepository.getAll()) {
            if (person.getRole().getRoleType().equals("ADMIN"))
                continue;
            else
                list.add(person.getNickname());
        }
        return list;
    }

    public List<Cards> findCradsByNickname(String nickname) {
        return personRepository.findCardsByNickname(nickname);
    }

    public Cards findByCardbyID(int id) { return personRepository.findByCardbyID(id);}
//    public CardBalance findBalanceByNickname(String nickname) {
//        return personRepository.findBalanceByNickname(nickname);
//    }



    public void update(Persons persons){
        personRepository.update(persons);
    }
    public void updPass (String mail, String pass){
        Persons persons = new Persons();
        persons = personRepository.findByEmail(mail);
        persons.setPassword(passwordEncoder.encode(pass));
    }
    public List<Persons> getAll(){
        return personRepository.getAll();
    }


    public List<Persons> getAllPersonsWithCrads(){
        return personRepository.getPersonsWithCards();
    }


    public void addUserCard(String id, String name){
        Cards cards = cardsRepository.findByCardKey(Long.parseLong(id));
        Persons persons = personRepository.findByNickname(GetRole.getPrincipal());
        cards.setCardName(name);
        cards.setPersonId(persons.getPersonId());
        System.out.println("addUserCard" + "Service"  + cards.toString());

        //    System.out.println(cards.toString());
//        if(cards.getPersonId()==null){cards.setPersonId(Long.valueOf(id)); cards.setCardName(name);}
    }

}
