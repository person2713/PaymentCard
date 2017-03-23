package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.PersonsPersonsProfilePK;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class PersonsPersonsProfilePKRepository extends AbstractRepository<PersonsPersonsProfilePK> {
    public PersonsPersonsProfilePKRepository() {
        super(PersonsPersonsProfilePK.class);
    }
}
