package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.TypeCard;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class TypeCardRepository extends AbstractRepository<TypeCard> {
    public TypeCardRepository() {
        super(TypeCard.class);
    }
}
