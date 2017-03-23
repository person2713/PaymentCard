package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.CarAssign;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class CarAssignRepository extends AbstractRepository<CarAssign> {
    public CarAssignRepository() {
        super(CarAssign.class);
    }
}
