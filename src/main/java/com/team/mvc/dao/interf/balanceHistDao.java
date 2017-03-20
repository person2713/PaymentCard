package com.team.mvc.dao.interf;

import com.team.mvc.entity.BalanceHistEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface balanceHistDao {
    //+ add forei key into entity
    BalanceHistEntity findBalanceHistByCardID(long card_id);
    BalanceHistEntity findBalanceHistByBalanceID(long balance_id);
    void saveCardBalance( BalanceHistEntity balanceHistEntity);
    List<BalanceHistEntity> findAllBalance();

    void deleteCardBalancebyBalHistID(long balance_id);
}
