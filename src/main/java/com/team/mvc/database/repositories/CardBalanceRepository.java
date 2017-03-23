package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.CardBalance;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class CardBalanceRepository extends AbstractRepository<CardBalance> {
    public CardBalanceRepository() {
        super(CardBalance.class);
    }
}
