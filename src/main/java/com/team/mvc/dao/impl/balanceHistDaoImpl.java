package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.balanceHistDao;
import com.team.mvc.entity.BalanceHist;
import com.team.mvc.dao.interf.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class balanceHistDaoImpl extends AbstractDao<Long,BalanceHist> implements balanceHistDao {
    @Override
    public List<BalanceHist>  findBalanceHistByCardID(long cardId) {

        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("CARD_ID", cardId));
        return (List<BalanceHist>) criteria.list();


    }

    @Override
    public List<BalanceHist> findBalanceHistByBalanceID(long balance_id) {



        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("BALANCE_ID", balance_id));
        return (List<BalanceHist>) criteria.list();
    }

    @Override
    public BalanceHist findBalanceHistByBalanceHistID(long balanceHistId) {
        return getByKey(balanceHistId);
    }

    @Override
    public void saveCardBalance(BalanceHist balanceHistEntity) {
        persist(balanceHistEntity);

    }

    @Override
    public List<BalanceHist> findAllBalance() {

        Criteria criteria = createEntityCriteria();
        return (List<BalanceHist>) criteria.list();
    }

    @Override
    public void deleteCardBalancebyBalHistID(long balance_id) {
        Query query = getSession().createSQLQuery("delete from BALANCE_HIST where BALANCE_HIST_ID = :balance_id");
        query.setLong("balance_id", balance_id);
        query.executeUpdate();
    }
}
