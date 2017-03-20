package com.team.mvc.dao.interf;

import com.team.mvc.entity.CardsEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface cardsDao {

    CardsEntity findById(long cardId);

    void saveCard( CardsEntity cardsEntity);

    void deleteCardbyCardID(long cardId);

    List<CardsEntity> findAllCards();

    CardsEntity findCardsByCardID(long cardId);
}
