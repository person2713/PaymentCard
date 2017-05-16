package com.team.mvc.database.repositories;


import com.team.mvc.database.entities.Rollers;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class RoleRepository extends AbstractRepository<Rollers> {

    public RoleRepository() {
        super(Rollers.class);
    }


    public Rollers findByType(String type) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("roleType", type));
        return (Rollers) criteria.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Rollers> findAll(){
        Criteria crit = createEntityCriteria();
//        crit.addOrder(Order.asc("role_type"));
        return (List<Rollers>)crit.list();
    }



}
