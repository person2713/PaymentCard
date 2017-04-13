package com.team.mvc.API.DriverTerminal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.team.mvc.database.entities.CarAssign;
import com.team.mvc.database.repositories.CarAssignRepository;
import com.team.mvc.database.services.CarAssignService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * Created by dronp on 08.04.2017.
 */
@RestController
@RequestMapping(value = "/API/carAssignment", method = RequestMethod.POST)
public class CarAssignmentAPI {
    //    ObjectMapper mapper = new ObjectMapper();
    @Autowired
    CarAssignService carAssignService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> onAssignCar(@RequestBody CarAssignClass carAssignment) {
        try {
            CarAssign carAssign = carAssignService.generateCarAssign(carAssignment.getBusId(),
                    carAssignment.getDriverId(),
                    carAssignment.getRouteId());
            carAssignService.save(carAssign);

            return new ResponseEntity<Object>(42, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static protected class CarAssignClass implements Serializable {
        private long BusId;
        private long DriverId;
        private long RouteId;

        public CarAssignClass() {
        }

        public long getBusId() {
            return BusId;
        }

        public void setBusId(long busId) {
            BusId = busId;
        }

        public long getDriverId() {
            return DriverId;
        }

        public void setDriverId(long driverId) {
            DriverId = driverId;
        }

        public long getRouteId() {
            return RouteId;
        }

        public void setRouteId(long routeId) {
            RouteId = routeId;
        }
    }
}
