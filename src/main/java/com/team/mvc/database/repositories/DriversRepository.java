package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Drivers;
import org.springframework.stereotype.Repository;


@Repository
public class DriversRepository extends AbstractRepository<Drivers> {
    public DriversRepository() {
        super(Drivers.class);
    }
}
