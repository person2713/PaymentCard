package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.PersonsProfile;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class PersonsProfileRepository extends AbstractRepository<PersonsProfile> {
    public PersonsProfileRepository() {
        super(PersonsProfile.class);
    }
}
