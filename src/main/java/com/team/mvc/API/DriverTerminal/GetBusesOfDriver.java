package com.team.mvc.API.DriverTerminal;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.BusesService;
import com.team.mvc.database.services.DriversService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.log.Const;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/API/driver/Buses", method = RequestMethod.GET)
public class GetBusesOfDriver {
    @Autowired
    PersonService personService;
    @Autowired
    DriversService driversService;
    @Autowired
    BusesService busesService;
    public static final Logger logger = Logger.getLogger(GetBusesOfDriver.class.getName());
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> onGetBusesOfDriver(HttpServletRequest request) {
        String log = "";
        try {
            log += request.getRemoteAddr() + "\t";
            Persons person = personService.findByNickname(GetRole.getPrincipal());
            log += "PersonId:" + person.getPersonId() + ", ";
            Drivers driver = driversService.findByPerson(person);
            log += "DriverId:" + driver.getDriverId();
            List<Buses> routes = busesService.findByCompanyId(driver.getCompanyId());
            HashMap<Long, String> routesMap = new HashMap<>();
            for (Buses bus : routes)
                routesMap.put(bus.getBusId(), bus.getBusNumber());
            CSRFTokenSerializable<String> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), mapper.writeValueAsString(routesMap));
            return new ResponseEntity<Object>(serToken, HttpStatus.OK);
        } catch (Exception ex) {
            log += "Error: " + ex.getMessage();
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (Const.DEBUG) {
                if (logger.isDebugEnabled()) {
                    logger.debug("POST : /API/driver/Routes\n " +
                            "" + log);
                }
            }
        }
    }
}
