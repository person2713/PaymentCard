package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.balanceHistDao;
import com.team.mvc.entity.BalanceHistEntity;
import com.team.mvc.dao.interf.AbstractDao;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class balanceHistDaoImpl extends AbstractDao<Long,BalanceHistEntity> implements balanceHistDao {
    @Override
    public BalanceHistEntity findBalanceHistByCardID(long card_id) {
        return null;
    }

    @Override
    public BalanceHistEntity findBalanceHistByBalanceID(long balance_id) {
        return null;
    }

    @Override
    public void saveCardBalance(BalanceHistEntity balanceHistEntity) {

    }

    @Override
    public List<BalanceHistEntity> findAllBalance() {
        return null;
    }

    @Override
    public void deleteCardBalancebyBalHistID(long balance_id) {

    }
}
