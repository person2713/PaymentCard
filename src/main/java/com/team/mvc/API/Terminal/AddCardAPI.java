package com.team.mvc.API.Terminal;

/**
 * Created by dronp on 13.05.2017.
 */

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.team.mvc.database.entities.CardBalance;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.services.CardBalanceService;
import com.team.mvc.database.services.CardsService;
import com.team.mvc.database.services.TypeCardService;
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
@RequestMapping(value = "/API/admin/card", method = RequestMethod.POST)
public class AddCardAPI {
    @Autowired
    CardsService cardsService;
    @Autowired
    TypeCardService typeCardService;
    @Autowired
    CardBalanceService cardBalanceService;
    public static final Logger logger = Logger.getLogger(LoginAPI.class.getName());
    ObjectMapper mapper = new ObjectMapper();

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResponseEntity<?> onAddCard(HttpServletRequest request, @RequestBody AddedCard addedCard) {
        String log = "";
        try {
            log += request.getRemoteAddr() + "\t";
            log += "addedCard: " + mapper.writeValueAsString(addedCard) + ", ";
            Cards card = cardsService.findByCardKey(addedCard.getCardKey());
            CardBalance cardBalance;
            if (card == null) {
                log += "card not existing. Creating new, ";
                card = new Cards();
                card.setCardKey(addedCard.getCardKey());

            } else {
                log += "card existing., ";
                cardBalance = card.getCardBalance();
            }
            card.setTypeCard(typeCardService.getTypeCardByStatusAndType("активна", addedCard.getCardType()));
            card.setPersonId(0L);
//            cardBalance = new CardBalance();
//            cardBalance.setCard(card);
            //card.setCardBalance(cardBalance);
            if (card.getCardId() == null)
                cardsService.saveCard(card);
            else cardsService.update(card);
            card=cardsService.findByCardKey(addedCard.getCardKey());
            cardBalance=cardBalanceService.findByCard(card);
            cardBalance.setBalance(new BigDecimal(addedCard.getBalance()));
//            cardBalance.setBalance(new BigDecimal(addedCard.getBalance()));
//            if (cardBalance.getBalanceId() == null)
//                cardBalanceService.save(cardBalance);
//            else cardBalanceService.update(cardBalance);
            cardBalanceService.update(cardBalance);
            CSRFTokenSerializable<Long> serToken = new CSRFTokenSerializable<>(Utils.getCsrfToken(request), 42L);
            return new ResponseEntity<Object>(serToken, HttpStatus.OK);
        } catch (Exception ex) {
            log += "Error: " + ex.getMessage();
            log="Error!!!! "+log;
            return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            if (Const.DEBUG) {
                if (logger.isDebugEnabled()) {
                    logger.debug("POST : /API/admin/card\n " +
                            "" + log);
                }
            }
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    static protected class AddedCard implements Serializable {
        private Long CardKey;
        private String Balance;
        private String CardType;


        public AddedCard() {
        }

        public Long getCardKey() {
            return CardKey;
        }

        public void setCardKey(Long cardKey) {
            CardKey = cardKey;
        }

        public String getBalance() {
            return Balance;
        }

        public void setBalance(String balance) {
            Balance = balance;
        }

        public String getCardType() {
            return CardType;
        }

        public void setCardType(String cardType) {
            CardType = cardType;
        }
    }
}