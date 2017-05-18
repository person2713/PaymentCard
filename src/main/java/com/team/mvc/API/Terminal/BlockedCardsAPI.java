package com.team.mvc.API.Terminal;

import com.team.mvc.database.services.BlackListService;
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
import java.util.List;

@RestController
@RequestMapping(value = "/API/getBlockedCards", method = RequestMethod.GET)
public class BlockedCardsAPI {

    @Autowired
    BlackListService blackListService;
    ObjectMapper mapper = new ObjectMapper();
    public static final Logger logger = Logger.getLogger(BlockedCardsAPI.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> onGettingBlockedCards(HttpServletRequest request/*,@RequestBody UserNamePass user*/) {
        String log = "";
        try {
            log += request.getRemoteAddr() + "\t";
            CSRFTokenSerializable<List<Long>> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), blackListService.getAllBlockCardKeys());
            return new ResponseEntity<Object>(serToken, HttpStatus.OK);
        } catch (Exception ex) {
            log += "Error: " + ex.getMessage();
            log="Error!!!! "+log;
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (Const.DEBUG) {
                if (logger.isDebugEnabled()) {
                    logger.debug("GET : /API/getBlockedCards\n " +
                            "" + log);
                }
            }
        }
    }
}
