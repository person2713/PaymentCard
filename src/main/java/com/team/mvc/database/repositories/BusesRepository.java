package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Routes;
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
public class BusesRepository extends AbstractRepository<Buses> {
    public BusesRepository() {
        super(Buses.class);
    }

    public void save(Buses bus) {
        super.save(bus);
    }

    public List<Buses> findByCompanyId(long companyId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("companyId", companyId));
        return criteria.list();
    }

    @Override
    public List<Buses> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("busId"));
        return criteria.list();
    }

    public Buses findByBusNumber(String busNumber) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("busNumber", busNumber));
        return (Buses) criteria.uniqueResult();
    }

    @Override
    public void update(Buses bus) {

        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Query query = session.createSQLQuery(
                    "update buses set bus_number=:busNumber, company_id=:companyId where bus_id=:busId");
            query.setParameter("busNumber", bus.getBusNumber());
            query.setParameter("companyId", bus.getCompanyId());
            query.setParameter("busId", bus.getBusId());
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

}
