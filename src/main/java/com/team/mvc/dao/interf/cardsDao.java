package com.team.mvc.dao.interf;

import com.team.mvc.entity.Cards;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface cardsDao {

    Cards findById(long cardId);

    void saveCard( Cards cardsEntity);

    void deleteCardbyCardID(long cardId);

    List<Cards> findAllCards();

    List<Cards> findCardsByPersonID(int personId);
}
