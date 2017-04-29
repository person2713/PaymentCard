package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.TypeCard;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TypeCardRepository extends AbstractRepository<TypeCard> {
    public TypeCardRepository() {
        super(TypeCard.class);
    }


    public TypeCard getTypeCarbyStatus(String status) {

        for (TypeCard typeCard : super.getAll()) {
            if(typeCard.getStatus().equals(status)){
                return typeCard;
            }
        }
        return null;
    }
}
