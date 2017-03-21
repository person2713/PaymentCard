package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.balanceHistDao;
import com.team.mvc.entity.BalanceHistEntity;
import com.team.mvc.dao.interf.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class balanceHistDaoImpl extends AbstractDao<Long,BalanceHistEntity> implements balanceHistDao {
    @Override
    public List<BalanceHistEntity>  findBalanceHistByCardID(long card_id) {
        Query query = getSession().createSQLQuery(
                "select * from BALANCE_HIST where CARD_ID = :card_id")
                .addEntity(BalanceHistEntity.class)
                .setParameter("card_id", "card_id");
        List result = query.list();
        return result;



    }

    @Override
    public List<BalanceHistEntity> findBalanceHistByBalanceID(long balance_id) {

        Query query = getSession().createSQLQuery(
                "select * from BALANCE_HIST where BALANCE_ID = :balance_id")
                .addEntity(BalanceHistEntity.class)
                .setParameter("balance_id", "balance_id");
        List result = query.list();
        return result;
    }

    @Override
    public BalanceHistEntity findBalanceHistByBalanceHistID(long balanceHistId) {
        return getByKey(balanceHistId);
    }

    @Override
    public void saveCardBalance(BalanceHistEntity balanceHistEntity) {
        persist(balanceHistEntity);

    }

    @Override
    public List<BalanceHistEntity> findAllBalance() {

        Criteria criteria = createEntityCriteria();
        return (List<BalanceHistEntity>) criteria.list();
    }

    @Override
    public void deleteCardBalancebyBalHistID(long balance_id) {
        Query query = getSession().createSQLQuery("delete from BALANCE_HIST where BALANCE_HIST_ID = :balance_id");
        query.setLong("balance_id", balance_id);
        query.executeUpdate();
    }
}
