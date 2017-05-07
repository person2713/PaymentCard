package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.TypeCard;<<<<<<< HEAD
import com.team.mvc.database.entities.TypeCard;
import org.hibernate.Criteria;
import org.hibernate.Query;
=======
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.TypeCard;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
>>>>>>> vv
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class TypeCardRepository extends AbstractRepository<TypeCard> {
    public TypeCardRepository() {
        super(TypeCard.class);
    }

    public List<TypeCard> getByStatus(String status) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("status", status));
        return criteria.list();
    }

    public void save(TypeCard typeCard) {
        super.save(typeCard);
    }

    @Override
    public List<TypeCard> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("typeId"));
        return criteria.list();
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
