package com.team.mvc.API.DriverTerminal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Drivers;
import com.team.mvc.database.entities.Persons;
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
import java.io.Serializable;

@RestController
@RequestMapping(value = "/API/driverLogin")
public class DriverLoginAPI {

    @Autowired
    PersonService personService;
    @Autowired
    DriversService driversService;

    public static final Logger logger = Logger.getLogger(DriverLoginAPI.class.getName());
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET/*,consumes = "application/json"*/)
    @ResponseBody
    public ResponseEntity<?> onLoginDriver(HttpServletRequest request/*,@RequestBody UserNamePass user*/) {
        String log="";
        try {
            log+=request.getRemoteAddr()+"\t";
            Persons driverPerson=personService.findByNickname(GetRole.getPrincipal());
            log+="PersonId:"+driverPerson.getPersonId()+", ";
            Drivers driver=driversService.findByPerson(driverPerson);
            log+="DriverId:"+driver.getDriverId();
            CSRFTokenSerializable<Long> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request),driver.getDriverId());
            return new ResponseEntity<Object>(serToken, HttpStatus.OK);
        } catch (Exception ex) {
            log += "Error: " + ex.getMessage();
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (Const.DEBUG) {
                if (logger.isDebugEnabled()) {
                    logger.debug("POST : /API/driverLogin\n " +
                            "" + log);
                }
            }
        }
    }

    @RequestMapping(value = "/csrf-token", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCsrfToken(HttpServletRequest request) {
//        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

        CSRFTokenSerializable serToken = new CSRFTokenSerializable(Utils.getCsrfToken(request));
        try {
             return new ResponseEntity<Object>(mapper.writeValueAsString(serToken), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<Object>("Error in converting object",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
protected class UserNamePass implements Serializable{
    private String username;
    private String passHash;
    public UserNamePass() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }
}

}
