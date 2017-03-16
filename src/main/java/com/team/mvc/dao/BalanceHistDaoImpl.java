package com.team.mvc.dao;

import com.team.mvc.entity.BalanceHistEntity;
import org.hibernate.Query;

/**
 * Created by vit on 16.03.2017.
 */
public class BalanceHistDaoImpl extends GenericDaoImpl<BalanceHistEntity, Number> implements BalanceHistDao {

    @Override
    public void add(com.team.mvc.entity.BalanceHistEntity entity) {

    }

    @Override
    public void saveOrUpdate(com.team.mvc.entity.BalanceHistEntity entity) {

    }

    @Override
    public void update(com.team.mvc.entity.BalanceHistEntity entity) {

    }

    @Override
    public void remove(com.team.mvc.entity.BalanceHistEntity entity) {

    }

    @Override
    public com.team.mvc.entity.BalanceHistEntity find(java.lang.Number key) {
        return null;
    }

    @Override
    public boolean removeBalanceHistEntity(java.lang.Number BalanceHistID) {
        return false;
    }

    @Override
    public com.team.mvc.entity.BalanceHistEntity getBalanceHistEntity(java.lang.Number balanceHistId) {
        Query query = currentSession().createQuery(
                "from BalanceHistEntity " +
                        "where balanceHistId=:balanceHistId");
        query.setParameter("balanceHistId", balanceHistId);
        return (BalanceHistEntity) query.uniqueResult();
    }
}
