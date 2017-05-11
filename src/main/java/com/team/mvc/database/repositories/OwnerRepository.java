package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.BalanceHist;
import com.team.mvc.database.entities.Owners;
import org.springframework.stereotype.Repository;


@Repository
public class OwnerRepository extends AbstractRepository<Owners>{
    public OwnerRepository() {
        super(Owners.class);
    }
}
