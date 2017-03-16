package com.team.mvc.dao;

import com.team.mvc.entity.BalanceHistEntity;
import org.hibernate.Query;

/**
 * Created by vit on 16.03.2017.
 */
public class BalanceHistDaoImpl  implements BalanceHistDao {


    @Override
    public boolean removeBalanceHistEntity(Number BalanceHistID) {
        return false;
    }

    @Override
    public BalanceHistEntity getBalanceHistEntity(Number CardID) {
        return null;
    }
}
