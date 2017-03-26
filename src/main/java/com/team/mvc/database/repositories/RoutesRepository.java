package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Routes;
import org.springframework.stereotype.Repository;



@Repository
public class RoutesRepository extends AbstractRepository<Routes> {
    public RoutesRepository() {
        super(Routes.class);
    }
}
