package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.cardBalanceDao;
import com.team.mvc.entity.CardBalance;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class cardBalanceDaoImpl extends AbstractDao<Long,CardBalance> implements cardBalanceDao {
    @Override
    public CardBalance findByBalanceID(long balanceId) {
        return getByKey(balanceId);
    }

    @Override
    public CardBalance findByCardID(long CardID) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("CARD_ID", CardID));
        return (CardBalance) criteria.uniqueResult();
    }

    @Override
    public void saveCardBalance(CardBalance cardBalanceEntity) {
        persist(cardBalanceEntity);
    }

    @Override
    public List<CardBalance> findAllBalance() {

        Criteria criteria = createEntityCriteria();
        return (List<CardBalance>) criteria.list();

    }

    @Override
    public void deleteCardBalancebyCardId(long CardID) {
        Query query = getSession().createSQLQuery("delete from CARD_BALANCE where  = :CardID");
        query.setParameter("CardID", CardID);
        query.executeUpdate();

    }
}
