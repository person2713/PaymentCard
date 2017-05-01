package com.team.mvc.job;

import com.team.mvc.database.entities.TemporaryEvents;
import com.team.mvc.database.repositories.CardsRepository;
import com.team.mvc.database.repositories.TemporaryEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**

 */
@Service("BlockCardsJob")
@EnableScheduling
public class BlockCardsJob {

    @Autowired
    TemporaryEventsRepository temporaryEventsRepository;
    @Autowired
    CardsRepository cardsRepository;

    @Scheduled(cron = "*/100000 * * * * *")
    public void block() {

        List<TemporaryEvents> temporaryEventsList = temporaryEventsRepository.getAllTemporaryEvents();

     /*   for (TemporaryEvents events :
                temporaryEventsList) {
            cardIDList.add(events.getCard().getCardId());

        }*/
        for (int w = 0; w < temporaryEventsList.size(); w++) {
            System.out.println(temporaryEventsList.get(w) + "  " + w + "  index");
        }


        List<TemporaryEvents> cardIDCOMMONList = new ArrayList<>(temporaryEventsList.size());
        for (int i = 0; i < temporaryEventsList.size(); i++) {
            for (int k = 0; k < temporaryEventsList.size(); k++) {
                if (((Math.abs(((int)temporaryEventsList.get(i).getLatitude() - (int)temporaryEventsList.get(k).getLatitude()))+Math.abs(((int)temporaryEventsList.get(i).getLongitude() - (int)temporaryEventsList.get(k).getLongitude()))))>30 && (temporaryEventsList.get(i).getCard().getCardId() == temporaryEventsList.get(k).getCard().getCardId())&& (i != k) )
                    cardIDCOMMONList.add(temporaryEventsList.get(i));
            }
        }
       // (temporaryEventsList.get(i).getCard().getCardId() == temporaryEventsList.get(k).getCard().getCardId())&& (i != k)
        for (int c = 0; c < cardIDCOMMONList.size(); c++) {
            System.out.println(cardIDCOMMONList.get(c) + "  " + c + "  indexCOMMON");
        }
        for (int b = 0; b < cardIDCOMMONList.size(); b++) {
            cardsRepository.blockCardById(cardIDCOMMONList.get(b).getCard().getCardId());
        }
        temporaryEventsRepository.delAll();

         /*  for (TemporaryEvents events :
                cardIDCOMMONList) {
            cardsRepository.blockCardById(events.getCard().getCardId());
            cardsRepository.blockCardById(22);
            System.out.println(events.getCard().getCardId());*/


        }


    }




