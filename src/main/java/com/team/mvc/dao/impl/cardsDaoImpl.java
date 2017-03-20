package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.cardsDao;
import com.team.mvc.entity.CardsEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class cardsDaoImpl extends AbstractDao<Long, CardsEntity> implements cardsDao {
    @Override
    public CardsEntity findById(long cardId) {
        return null;
    }

    @Override
    public void saveCard(CardsEntity cardsEntity) {

    }

    @Override
    public void deleteCardbyCardID(long cardId) {

    }

    @Override
    public List<CardsEntity> findAllCards() {
        return null;
    }

    @Override
    public CardsEntity findCardsByCardID(long cardId) {
        return null;
    }
}
