package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Cities;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CitiesRepository extends AbstractRepository<Cities> {
    public CitiesRepository() {
        super(Cities.class);
    }

    public Cities findByName(String cityName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cityName", cityName));
        return (Cities) criteria.uniqueResult();
    }

    public List<Cities> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("cityName"));
        return criteria.list();
    }
}
