package com.team.mvc.database.services;

import com.team.mvc.database.entities.CardBalance;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.repositories.PersonRepository;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Persons findById(Integer id) throws NotFoundException {
        return personRepository.getById(id);
    }

    public Persons findByNickname(String nickname) {
        return personRepository.findByNickname(nickname);
    }

    public void savePerson(Persons persons){
        persons.setPassword(passwordEncoder.encode(persons.getPassword()));
        personRepository.save(persons);
    }

    public boolean isPersonsNicknameUnique(Integer id, String nickname) {
        Persons persons = findByNickname(nickname);
        return ( persons == null || ((id != null) && (persons.getPersonId() == id)));
    }

    public List<Cards> findCradsByNickname(String nickname) {return personRepository.findCardsByNickname(nickname);}
    public CardBalance findBalanceByNickname(String nickname) {return personRepository.findBalanceByNickname(nickname);}
}
