package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Cities;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class CitiesRepository extends AbstractRepository<Cities> {
    public CitiesRepository() {
        super(Cities.class);
    }
}
