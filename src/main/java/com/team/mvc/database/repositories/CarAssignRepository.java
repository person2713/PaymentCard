package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.CarAssign;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CarAssignRepository extends AbstractRepository<CarAssign> {

    public CarAssignRepository() {
        super(CarAssign.class);
    }

    public void save(CarAssign carAssign) {
        super.save(carAssign);
    }

    @Override
    public List<CarAssign> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("carAssignId"));
        return criteria.list();
    }

    public List getAllForDriver(Long driverId) {
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("driverId", driverId));
        criteria.addOrder(Order.asc("carAssignId"));
        return criteria.list();
    }

}
