package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Persons;
import org.springframework.stereotype.Repository;


@Repository
public class PersonsRepository extends AbstractRepository<Persons> {
    public PersonsRepository() {
        super(Persons.class);
    }
}
