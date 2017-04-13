package com.team.mvc.API.DriverTerminal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController; 

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@RestController
@RequestMapping(value = "/API/driverLogin")
public class DriverLoginAPI {

//    public static final Logger logger = Logger.getLogger(DriverLogin.class.getName());
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET/*,consumes = "application/json"*/)
    @ResponseBody
    public ResponseEntity<?> onLoginDriver(HttpServletRequest request/*,@RequestBody UserNamePass user*/) {

//        if (Const.DEBUG) {
//            if (logger.isDebugEnabled()) {
//                logger.debug("POST : /API/driverLogin\n " +
//                            ""+request.getRemoteUser());
//            }
//        }
        try {
            return new ResponseEntity<Object>(4, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/csrf-token", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getCsrfToken(HttpServletRequest request) {
//        CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
        CsrfToken token = new HttpSessionCsrfTokenRepository().loadToken(request);
            if (token==null){
                token=new HttpSessionCsrfTokenRepository().generateToken(request);
                new HttpSessionCsrfTokenRepository().saveToken(token,request,null);}
        CSRFTokenSerializable serToken = new CSRFTokenSerializable(token);
        try {
            return new ResponseEntity<Object>(mapper.writeValueAsString(serToken), HttpStatus.OK);
        }
        catch (Exception ex)
        {
            return new ResponseEntity<Object>("Error in converting object",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    protected class CSRFTokenSerializable implements Serializable{
        public String getX_CSRF_HEADER() {
            return X_CSRF_HEADER;
        }

        public void setX_CSRF_HEADER(String x_CSRF_HEADER) {
            X_CSRF_HEADER = x_CSRF_HEADER;
        }

        public String getX_CSRF_PARAM() {
            return X_CSRF_PARAM;
        }

        public void setX_CSRF_PARAM(String x_CSRF_PARAM) {
            X_CSRF_PARAM = x_CSRF_PARAM;
        }

        public String getX_CSRF_TOKEN() {
            return X_CSRF_TOKEN;
        }

        public void setX_CSRF_TOKEN(String x_CSRF_TOKEN) {
            X_CSRF_TOKEN = x_CSRF_TOKEN;
        }

        private String X_CSRF_HEADER;
        private String X_CSRF_PARAM;
        private String X_CSRF_TOKEN;

        public CSRFTokenSerializable(CsrfToken token) {
            X_CSRF_HEADER = token.getHeaderName();
            X_CSRF_PARAM = token.getParameterName();
            X_CSRF_TOKEN = token.getToken();
        }
//"X-CSRF-HEADER", token.getHeaderName()
//"X-CSRF-PARAM", token.getParameterName()
//"X-CSRF-TOKEN", token.getToken()
    }
    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static protected class UserNamePass implements Serializable{
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
