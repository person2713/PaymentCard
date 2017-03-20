package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.cardsDao;
import com.team.mvc.entity.CardsEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;

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
        persist(cardsEntity);
    }

    @Override
    public void deleteCardbyCardID(long cardId) {
        Query query = getSession().createSQLQuery("delete from CARDS where CARD_ID = :cardId");
        query.setParameter("cardId", cardId);
        query.executeUpdate();

    }

    @Override
    public List<CardsEntity> findAllCards() {
        Criteria criteria = createEntityCriteria();
        return (List<CardsEntity>) criteria.list();
    }

    @Override
    public CardsEntity findCardsByCardID(long cardId) {
        return null;
    }
}
