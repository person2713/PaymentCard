package com.team.mvc.API.Terminal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.services.BusesService;
import com.team.mvc.database.services.CardsService;
import com.team.mvc.database.services.PaymentService;
import com.team.mvc.database.services.RoutesService;
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

@RestController
@RequestMapping(value = "/API/driver/newEvent", method = RequestMethod.POST)
public class NewEventAPI {
    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    PaymentService paymentService;
    @Autowired
    CardsService cardsService;
    @Autowired
    BusesService busesService;
    @Autowired
    RoutesService routesService;

    public static final Logger logger = Logger.getLogger(LoginAPI.class.getName());

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
                CSRFTokenSerializable<String> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), "Карта не найдена");
                return new ResponseEntity<Object>(serToken, HttpStatus.NOT_FOUND);
            }
            Buses bus = busesService.findById(newEvent.getBusId());
            Routes route=routesService.findById(newEvent.getRouteId());
            if (paymentService.paymentPossibility(card.getCardId(),
                    getCost(route),
                    newEvent.getLatitude(),
                    newEvent.getLongitude(),
                    bus.getBusId())) {
                log += "OK";
                CSRFTokenSerializable<String> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), "OK");
                return new ResponseEntity<Object>(serToken, HttpStatus.OK);
            }
            log += "Not enough money";
            CSRFTokenSerializable<String> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), "Недостаточно средств");
            return new ResponseEntity<Object>(serToken, HttpStatus.PAYMENT_REQUIRED);
        } catch (Exception ex) {
            log += "Error: " + ex.getMessage();
            log="Error!!!! "+log;
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (Const.DEBUG) {
                if (logger.isDebugEnabled()) {
                    logger.debug("POST : /API/driver/newEvent\n " +
                            "" + log);
                }
            }
        }
    }

    public BigDecimal getCost(Routes route) {
        return route.getRoutePrice();
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static protected class NewEventClass implements Serializable {
        private Long BusId;
        private Double Longitude;
        private Double Latitude;
        private Long TagID;
        private Long RouteId;

        public NewEventClass() {
        }

        public Long getBusId() {
            return BusId;
        }

        public void setBusId(Long busId) {
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

        public Long getTagID() {
            return TagID;
        }

        public void setTagID(Long tagID) {
            TagID = tagID;
        }

        public Long getRouteId() {
            return RouteId;
        }

        public void setRouteId(Long routeId) {
            RouteId = routeId;
        }
    }
}
