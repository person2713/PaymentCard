package com.team.mvc.API.DriverTerminal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.team.mvc.database.entities.Buses;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.services.BusesService;
import com.team.mvc.database.services.CardsService;
import com.team.mvc.database.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; 

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by dronp on 09.04.2017.
 */
@RestController
@RequestMapping(value = "/API/newEvent", method = RequestMethod.POST)
public class NewEventAPI {
//    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    PaymentService paymentService;
    @Autowired
    CardsService cardsService;
    @Autowired
    BusesService busesService;


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public ResponseEntity<?> onNewEvent(@RequestBody NewEventClass newEvent) {
        try {
            Cards card=cardsService.findByCardKey(newEvent.getTagID());
            if (card==null)
                return new ResponseEntity<Object>("Карта не найдена",HttpStatus.NOT_FOUND);
            Buses bus=busesService.findById(newEvent.getBusId());
            if (paymentService.paymentPossibility(card,
                                                    getCost(card),
                                                    newEvent.getLatitude(),
                                                    newEvent.getLongitude(),
                                                    new Timestamp((new Date()).getTime()),
                                                    bus))
                return new ResponseEntity<Object>("OK",HttpStatus.OK);
            return new ResponseEntity<Object>("Недостаточно средств", HttpStatus.PAYMENT_REQUIRED);
        } catch (Exception ex) {
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public BigDecimal getCost(Cards card)
    {
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
