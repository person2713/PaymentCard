package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Persons;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository
public class CompaniesRepository extends AbstractRepository<Companies> {
    public CompaniesRepository() {
        super(Companies.class);
    }

    public Companies findByCompanyName(String companyName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("companyName", companyName));
        return (Companies) criteria.uniqueResult();
    }
}
