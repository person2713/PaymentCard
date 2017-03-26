package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Companies;
import org.springframework.stereotype.Repository;


@Repository
public class CompaniesRepository extends AbstractRepository<Companies> {
    public CompaniesRepository() {
        super(Companies.class);
    }
}
