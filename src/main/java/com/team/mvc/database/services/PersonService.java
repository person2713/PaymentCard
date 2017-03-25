package com.team.mvc.database.services;

import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.repositories.PersonRepository;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public Persons findById(long id) throws NotFoundException {
        return personRepository.getById(id);
    }

    public Persons findByNickName(String nickname) {
        return personRepository.findBySSO(nickname);
    }
}
