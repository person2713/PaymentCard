package com.team.mvc.API.Terminal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.team.mvc.database.entities.CarAssign;
import com.team.mvc.database.services.CarAssignService;
import com.team.mvc.log.Const;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;


@RestController
@RequestMapping(value = "/API/driver/carAssignment", method = RequestMethod.POST)
public class CarAssignmentAPI {
    @Autowired
    CarAssignService carAssignService;
    public static final Logger logger = Logger.getLogger(LoginAPI.class.getName());
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> onAssignCar(HttpServletRequest request, @RequestBody CarAssignClass carAssignment) {
        String log = "";
        try {
            log += request.getRemoteAddr() + "\t";
            log += "carAssignment: " + mapper.writeValueAsString(carAssignment) + ", ";
            CarAssign carAssign = carAssignService.generateCarAssign(carAssignment.getBusId(),
                    carAssignment.getDriverId(),
                    carAssignment.getRouteId());
            carAssignService.save(carAssign);
            CSRFTokenSerializable<Long> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), 42l);
            return new ResponseEntity<Object>(serToken, HttpStatus.OK);
        } catch (Exception ex) {
            log += "Error: " + ex.getMessage();
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (Const.DEBUG) {
                if (logger.isDebugEnabled()) {
                    logger.debug("POST : /API/driver/carAssignment\n " +
                            "" + log);
                }
            }
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
