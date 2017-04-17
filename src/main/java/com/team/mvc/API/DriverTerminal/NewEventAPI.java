package com.team.mvc.API.DriverTerminal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.services.BusesService;
import com.team.mvc.database.services.CardsService;
import com.team.mvc.database.services.PaymentService;
import com.team.mvc.log.Const;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@RestController
@RequestMapping(value = "/API/newEvent", method = RequestMethod.POST)
public class NewEventAPI {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    PaymentService paymentService;
    @Autowired
    CardsService cardsService;
    @Autowired
    BusesService busesService;

    public static final Logger logger = Logger.getLogger(DriverLoginAPI.class.getName());

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> onNewEvent(HttpServletRequest request, @RequestBody NewEventClass newEvent) {
        String log = "";
        try {
            log += request.getRemoteAddr() + "\t";
            log += "newEvent: " + mapper.writeValueAsString(newEvent) + ", ";
            Cards card = cardsService.findByCardKey(newEvent.getTagID());
            if (card == null) {
                log += "Card not found";
                return new ResponseEntity<Object>("Карта не найдена", HttpStatus.NOT_FOUND);
            }
            Buses bus = busesService.findById(newEvent.getBusId());
            if (paymentService.paymentPossibility(card,
                    getCost(card),
                    newEvent.getLatitude(),
                    newEvent.getLongitude(),
                    new Timestamp((new Date()).getTime()),
                    bus)) {
                log += "OK";
                CSRFTokenSerializable<String> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), "OK");
                return new ResponseEntity<Object>(serToken, HttpStatus.OK);
            }
            log += "Not enough money";
            CSRFTokenSerializable<String> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), "Недостаточно средств");
            return new ResponseEntity<Object>(serToken, HttpStatus.PAYMENT_REQUIRED);
        } catch (Exception ex) {
            log += "Error: " + ex.getMessage();
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (Const.DEBUG) {
                if (logger.isDebugEnabled()) {
                    logger.debug("POST : /API/newEvent\n " +
                            "" + log);
                }
            }
        }
    }

    public BigDecimal getCost(Cards card) {
        return new BigDecimal(15);
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static protected class NewEventClass implements Serializable {
        private Integer BusId;
        private Double Longitude;
        private Double Latitude;
        private long TagID;

        public NewEventClass() {
        }

        public Integer getBusId() {
            return BusId;
        }

        public void setBusId(Integer busId) {
            BusId = busId;
        }

        public Double getLongitude() {
            return Longitude;
        }

        public void setLongitude(Double longitude) {
            Longitude = longitude;
        }

        public Double getLatitude() {
            return Latitude;
        }

        public void setLatitude(Double latitude) {
            Latitude = latitude;
        }

        public long getTagID() {
            return TagID;
        }

        public void setTagID(long tagID) {
            TagID = tagID;
        }
    }
}
