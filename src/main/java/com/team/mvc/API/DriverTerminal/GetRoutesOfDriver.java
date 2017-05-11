package com.team.mvc.API.DriverTerminal;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.services.DriversService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoutesService;
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
import java.util.*;

@RestController
@RequestMapping(value = "/API/driver/Routes", method = RequestMethod.GET)
public class GetRoutesOfDriver {
    @Autowired
    PersonService personService;
    @Autowired
    DriversService driversService;
    @Autowired
    RoutesService routesService;
    public static final Logger logger = Logger.getLogger(GetRoutesOfDriver.class.getName());
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> onGetRoutesOfDriver(HttpServletRequest request) {
        String log = "";
        try {
            log += request.getRemoteAddr() + "\t";
            Persons person = personService.findByNickname(GetRole.getPrincipal());
            log += "PersonId:" + person.getPersonId() + ", ";
            Drivers driver = driversService.findByPerson(person);
            log += "DriverId:" + driver.getDriverId();
            List<Routes> routes = routesService.findByCompanyId(driver.getCompanyId());
            HashMap<Long, String> routesMap = new HashMap<>();
            for (Routes route : routes)
                routesMap.put(route.getRouteId(), route.getRouteNumber());
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
