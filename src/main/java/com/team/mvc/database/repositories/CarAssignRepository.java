package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.CarAssign;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Routes;
import javassist.NotFoundException;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
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
}
