package com.team.mvc.API.DriverTerminal;

import com.team.mvc.database.services.BlackListService;
import com.team.mvc.database.services.CardsService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/API/getBlockedCards", method = RequestMethod.GET)
public class BlockedCardsAPI {

    @Autowired
    BlackListService blackListService;
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> onGettingBlockedCards(HttpServletRequest request/*,@RequestBody UserNamePass user*/) {

//        if (Const.DEBUG) {
//            if (logger.isDebugEnabled()) {
//                logger.debug("POST : /API/driverLogin\n " +
//                            ""+request.getRemoteUser());
//            }
//        }
        try {

            //TODO: uncomment line bellow and comment other lines when blacklist will completed
            return new ResponseEntity<Object>(blackListService.getAllBlockCards(), HttpStatus.OK);
//            List<Long> blockedCards=new ArrayList<>();
//            blockedCards.add(42l);
//            blockedCards.add(23l);
//            String jsonObject=mapper.writeValueAsString(blockedCards);
//            return new ResponseEntity<Object>(jsonObject, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
