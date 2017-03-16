package com.team.mvc.dao;

import com.team.mvc.entity.BalanceHistEntity;

/**
 * Created by vit on 16.03.2017.
 */
public interface BalanceHistDao {

    public boolean removeBalanceHistEntity(Number BalanceHistID);

    public BalanceHistEntity getBalanceHistEntity(Number CardID);
}
