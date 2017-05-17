package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Persons;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class CompaniesRepository extends AbstractRepository<Companies> {
    public CompaniesRepository() {
        super(Companies.class);
    }

    public Companies findByCompanyName(String companyName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("companyName", companyName));
        return (Companies) criteria.uniqueResult();
    }

    public List<Companies> getCompaniesWithoutOwners(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createSQLQuery(
                "SELECT * " +
                        "FROM COMPANIES c LEFT JOIN OWNERS o " +
                            "on c.COMPANY_ID = o.COMPANY_ID " +
                        "WHERE o.OWNER_ID is null")
                .addEntity(Companies.class);
        return query.list();
    }

    @Override
    public void update(Companies company) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query = session.createSQLQuery(
                "update companies " +
                        "set company_name=:companyName, " +
                        "phone_number=:phoneNumber, " +
                        "comp_balance=:companyBalance, " +
                        "city_id=:cityId " +
                        "where company_id=:companyId");
        query.setParameter("companyName", company.getCompanyName());
        query.setParameter("phoneNumber", company.getPhoneNumber());
        query.setParameter("companyBalance", company.getCompBalance());
        query.setParameter("cityId", company.getCity().getCityId());
        query.setParameter("companyId", company.getCompanyId());
        query.executeUpdate();
        session.getTransaction().commit();

    }

}
