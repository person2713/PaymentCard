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

import java.math.BigDecimal;
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

    public Companies findByPhoneNumber(String companyName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("phoneNumber", companyName));
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
        List<Companies> companiesList = query.list();
        session.close();
        return companiesList;
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
        session.close();

    }

    @Override
    public void delete(Companies company) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query1 = session.createSQLQuery(
                "delete from car_assign " +
                        "where driver_id in (" +
                            "SELECT driver_id " +
                                "FROM DRIVERS " +
                                "WHERE COMPANY_ID =:companyId)");
        query1.setParameter("companyId", company.getCompanyId());
        query1.executeUpdate();

        Query query2 = session.createSQLQuery(
                        "delete from car_assign " +
                                "where bus_id IN (" +
                                    "SELECT bus_id " +
                                        "FROM BUSES " +
                                        "WHERE COMPANY_ID =:companyId)");
        query2.setParameter("companyId", company.getCompanyId());
        query2.executeUpdate();

        Query query3 = session.createSQLQuery(
                "delete from car_assign " +
                        "where route_id IN (" +
                            "SELECT route_id " +
                                "FROM ROUTES " +
                                "WHERE COMPANY_ID =:companyId)");
        query3.setParameter("companyId", company.getCompanyId());
        query3.executeUpdate();

        Query query4 = session.createSQLQuery(
                "delete from events " +
                        "where bus_id IN (" +
                            "SELECT bus_id " +
                                "FROM BUSES " +
                                "WHERE COMPANY_ID =:companyId)");
        query4.setParameter("companyId", company.getCompanyId());
        query4.executeUpdate();

        Query query5 = session.createSQLQuery("delete " +
                "from temporary_events " +
                "where  bus_id in(" +
                    "select bus_id " +
                        "from buses " +
                        "where company_id=:companyId)");
        query5.setParameter("companyId", company.getCompanyId());
        query5.executeUpdate();

        Query query6 = session.createSQLQuery(
                "delete from buses " +
                        "where bus_id IN (" +
                            "SELECT bus_id " +
                                "FROM BUSES " +
                                "WHERE COMPANY_ID =:companyId)");
        query6.setParameter("companyId", company.getCompanyId());
        query6.executeUpdate();

        Query query7 = session.createSQLQuery(
                "delete from ROUTES " +
                        "where route_id IN (" +
                            "SELECT route_id " +
                                "FROM ROUTES " +
                                "WHERE COMPANY_ID =:companyId)");
        query7.setParameter("companyId", company.getCompanyId());
        query7.executeUpdate();


        Query query8 = session.createSQLQuery(
                "delete from drivers " +
                        "where driver_id in (" +
                            "SELECT driver_id " +
                                "FROM DRIVERS " +
                                "WHERE COMPANY_ID =:companyId)");
        query8.setParameter("companyId", company.getCompanyId());
        query8.executeUpdate();

        Query query9 = session.createSQLQuery(
                "delete from owners " +
                        "where owner_id in (" +
                            "SELECT owner_id " +
                                "FROM owners " +
                                "WHERE company_id =:companyId)");
        query9.setParameter("companyId", company.getCompanyId());
        query9.executeUpdate();

        Query query10 = session.createSQLQuery(
                "delete from companies " +
                        "where company_id=:companyId");
        query10.setParameter("companyId", company.getCompanyId());
        query10.executeUpdate();

        session.getTransaction().commit();
        session.close();
    }


    @Override
    public void save(Companies company) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        if(company.getCompBalance()==null){
            company.setCompBalance(BigDecimal.ZERO);
        }
        Query query1 = session.createSQLQuery(
                "insert into companies (company_name, phone_number, comp_balance, city_id) " +
                        "VALUES (:companyName, :phoneNumber, :compBalance, :cityId)");
//        query1.setParameter("cardId", card.getCardId());
        query1.setParameter("companyName", company.getCompanyName());
        query1.setParameter("phoneNumber", company.getPhoneNumber());
        query1.setParameter("compBalance", company.getCompBalance());
        query1.setParameter("cityId", company.getCity().getCityId());
        query1.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
}
