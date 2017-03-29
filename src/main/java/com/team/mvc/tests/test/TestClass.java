package com.team.mvc.tests.test;

import com.team.mvc.database.repositories.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**

 */
@Component
public class TestClass {
    @Autowired
   PersonsRepository personsRepository;
    public void run(){ System.out.println( personsRepository.getAll());}
}
