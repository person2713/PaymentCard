package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Buses;
import org.springframework.stereotype.Repository;


@Repository
public class BusesRepository extends AbstractRepository<Buses> {
    public BusesRepository() {
        super(Buses.class);
    }
}
