package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.cardBalanceDao;
import com.team.mvc.entity.CardBalanceEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class cardBalanceDaoImpl extends AbstractDao<Long,CardBalanceEntity> implements cardBalanceDao {
    @Override
    public CardBalanceEntity findByBalanceID(long balanceId) {
        return null;
    }

    @Override
    public CardBalanceEntity findByCardID(long CardID) {
        return null;
    }

    @Override
    public void saveCardBalance(CardBalanceEntity cardBalanceEntity) {

    }

    @Override
    public List<CardBalanceEntity> findAllBalance() {
        return null;
    }

    @Override
    public void deleteCardBalancebyCardId(long CardID) {

    }
}
