package com.team.mvc.service.interf;

import com.team.mvc.entity.CardsEntity;

import java.util.List;

/**
 * Created by vit on 21.03.2017.
 */
public interface cardsService {
    CardsEntity findById(long cardId);

    void saveCard( CardsEntity cardsEntity);

    void deleteCardbyCardID(long cardId);

    List<CardsEntity> findAllCards();

    List<CardsEntity> findCardsByPersonID(int personId);
}
