package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.cardBalanceDao;
import com.team.mvc.entity.CardBalanceEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class cardBalanceDaoImpl extends AbstractDao<Long,CardBalanceEntity> implements cardBalanceDao {
    @Override
    public CardBalanceEntity findByBalanceID(long balanceId) {
        return getByKey(balanceId);
    }

    @Override
    public CardBalanceEntity findByCardID(long CardID) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("CardID", CardID));
        return (CardBalanceEntity) criteria.uniqueResult();
    }

    @Override
    public void saveCardBalance(CardBalanceEntity cardBalanceEntity) {
        persist(cardBalanceEntity);
    }

    @Override
    public List<CardBalanceEntity> findAllBalance() {

        Criteria criteria = createEntityCriteria();
        return (List<CardBalanceEntity>) criteria.list();

    }

    @Override
    public void deleteCardBalancebyCardId(long CardID) {
        Query query = getSession().createSQLQuery("delete from CARD_BALANCE where  = :CardID");
        query.setParameter("CardID", CardID);
        query.executeUpdate();

    }
}
