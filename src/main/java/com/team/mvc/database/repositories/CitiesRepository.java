package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Cities;
import org.springframework.stereotype.Repository;


@Repository
public class CitiesRepository extends AbstractRepository<Cities> {
    public CitiesRepository() {
        super(Cities.class);
    }
}
