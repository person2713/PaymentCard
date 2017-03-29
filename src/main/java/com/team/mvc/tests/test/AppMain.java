package com.team.mvc.tests.test;

import com.team.mvc.database.entities.*;
import com.team.mvc.database.repositories.PersonsRepository;
import com.team.mvc.tests.utils.HibernateUtil;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**

 */
@Component
public class AppMain {
    @Autowired
    static PersonsRepository personsRepository;


    public static void main(String[] args) {
        System.out.println(new PersonsRepository().getAll());



    }
}
