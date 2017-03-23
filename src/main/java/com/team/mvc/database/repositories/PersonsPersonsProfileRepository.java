package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.PersonsPersonsProfile;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class PersonsPersonsProfileRepository extends AbstractRepository<PersonsPersonsProfile> {
    public PersonsPersonsProfileRepository() {
        super(PersonsPersonsProfile.class);
    }
}
