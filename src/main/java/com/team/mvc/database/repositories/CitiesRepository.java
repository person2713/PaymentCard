package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Cities;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CitiesRepository extends AbstractRepository<Cities> {
    public CitiesRepository() {
        super(Cities.class);
    }

    public Cities findByName(String cityName) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("cityName", cityName));
        return (Cities) crit.uniqueResult();
    }

    public List<Cities> getAll() {
        return super.getAll();
    }
}
