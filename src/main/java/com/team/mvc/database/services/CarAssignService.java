package com.team.mvc.database.services;

import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.CarAssign;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.repositories.BusesRepository;
import com.team.mvc.database.repositories.CarAssignRepository;
import com.team.mvc.database.repositories.DriversRepository;
import com.team.mvc.database.repositories.RoutesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CarAssignService {

    @Autowired
    CarAssignRepository carAssignRepository;
    @Autowired
    BusesService busesService;
    @Autowired
    DriversService driversService;
    @Autowired
    RoutesService routesService;

    public void save(CarAssign carAssign){
        carAssignRepository.save(carAssign);
    }

    public CarAssign generateCarAssign(Long BusId,
                                       Long DriverId,
                                       Long RouteId) throws NotFoundException {
        CarAssign carAssign = new CarAssign();
//
//        Buses bus=busesService.findById(BusId);
//        Drivers driver=driversService.findById(DriverId);
//        Routes routes=routesService.findById(RouteId);
//        carAssign.setBusId(bus.getBusId());
//        carAssign.setDriverId(driver.getDriverId());
//        carAssign.setRouteId(routes.getRouteId());
        carAssign.setBusId(BusId);
        carAssign.setDriverId(DriverId);
        carAssign.setRouteId(RouteId);
        return carAssign;
    }

    public List<CarAssign> getAll(){
        return carAssignRepository.getAll();
    }
}
