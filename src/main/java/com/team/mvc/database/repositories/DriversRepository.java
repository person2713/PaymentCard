package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Persons;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class DriversRepository extends AbstractRepository<Drivers> {
    public DriversRepository() {
        super(Drivers.class);
    }

    public void save(Drivers driver) {
        super.save(driver);
    }

    public Drivers getByPerson(Persons person) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("person", person));
        return (Drivers) criteria.uniqueResult();
    }

    @Override
    public List<Drivers> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("driverId"));
        return criteria.list();
    }

    public Drivers findByNickname(String nickname) {
        Session session = sessionFactory.openSession();
        Query query = session.createSQLQuery(String.format("select * from drivers d left join persons p on d.person_id = p.person_id where p.nickname= :nickname"))
                .addEntity(Drivers.class).setParameter("nickname", nickname);
        Drivers driver =(Drivers) query.uniqueResult();
        session.close();
        return driver;
    }

    @Override
    public void update(Drivers driver) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query1 = session.createSQLQuery(
                "update drivers " +
                        "set company_id=:companyId " +
                        "where driver_id=:driverId");
        query1.setParameter("companyId", driver.getCompanyId());
        query1.setParameter("driverId", driver.getDriverId());
        query1.executeUpdate();
        Query query2 = session.createSQLQuery(
                "update persons " +
                        "set nickname=:nickname, " +
                        "first_name=:firstName, " +
                        "last_name=:lastName, " +
                        "mobile_number=:mobileNumber, " +
                        "email=:email, " +
                        "city_id=:cityId, " +
                        "role_id=:roleId " +
                        "where person_id=:personId");
        query2.setParameter("nickname", driver.getPerson().getNickname());
        query2.setParameter("firstName", driver.getPerson().getFirstName());
        query2.setParameter("lastName", driver.getPerson().getLastName());
        query2.setParameter("mobileNumber", driver.getPerson().getMobileNumber());
        query2.setParameter("email", driver.getPerson().getEmail());
        query2.setParameter("cityId", driver.getPerson().getCity().getCityId());
        query2.setParameter("roleId", driver.getPerson().getRole().getRoleId());
        query2.setParameter("personId", driver.getPerson().getPersonId());
        query2.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(Drivers driver) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Query query1 = session.createSQLQuery(
                "delete from car_assign " +
                        "where driver_id=:driverId");
        query1.setParameter("driverId", driver.getDriverId());
        query1.executeUpdate();

        Query query2 = session.createSQLQuery(
                "delete from drivers " +
                        "where driver_id=:driverId");
        query2.setParameter("driverId", driver.getDriverId());
        query2.executeUpdate();

        Query query3 = session.createSQLQuery(
                "delete from persons " +
                        "where person_id=:personId");
        query3.setParameter("personId", driver.getPerson().getPersonId());
        query3.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

}
