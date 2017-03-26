package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Cards;
import org.springframework.stereotype.Repository;

@Repository
public class CardsRepository extends AbstractRepository<Cards> {
    public CardsRepository() {
        super(Cards.class);
    }
}
