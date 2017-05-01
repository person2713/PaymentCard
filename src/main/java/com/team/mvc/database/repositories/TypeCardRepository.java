package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.TypeCard;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
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

//
//    public TypeCard findTypeCardByStatus(String status) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("status", status));
//        return (TypeCard) criteria.uniqueResult();
//    }
}
