package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.cardsDao;
import com.team.mvc.entity.Cards;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class cardsDaoImpl extends AbstractDao<Long, Cards> implements cardsDao {
    @Override
    public Cards findById(long cardId) {
        return getByKey(cardId);
    }

    @Override
    public void saveCard(Cards cardsEntity) {
        persist(cardsEntity);
    }

    @Override
    public void deleteCardbyCardID(long cardId) {
        Query query = getSession().createSQLQuery("delete from CARDS where CARD_ID = :cardId");
        query.setParameter("cardId", cardId);
        query.executeUpdate();

    }

    @Override
    public List<Cards> findAllCards() {
        Criteria criteria = createEntityCriteria();
        return (List<Cards>) criteria.list();
    }

    @Override
    public  List<Cards> findCardsByPersonID(int personId) {

        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("PERSON_ID", personId));
        return (List<Cards>) criteria.list();
    }
}
