package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Rollers;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


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
}
