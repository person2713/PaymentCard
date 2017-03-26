package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.BalanceHist;
import org.springframework.stereotype.Repository;


@Repository
public class BalanceHistRepository extends AbstractRepository<BalanceHist> {
    public BalanceHistRepository() {
        super(BalanceHist.class);
    }
}
