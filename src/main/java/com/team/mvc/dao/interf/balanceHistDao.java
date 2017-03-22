package com.team.mvc.dao.interf;

import com.team.mvc.entity.BalanceHistEntity;
import com.team.mvc.entity.BalanceHistEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface balanceHistDao {
    //+ add forei key into entity
    List<BalanceHistEntity> findBalanceHistByCardID(long cardId);
    List<BalanceHistEntity> findBalanceHistByBalanceID(long balance_id);
    BalanceHistEntity findBalanceHistByBalanceHistID (long balanceHistId);
    void saveCardBalance( BalanceHistEntity balanceHistEntity);
    List<BalanceHistEntity> findAllBalance();

    void deleteCardBalancebyBalHistID(long balance_id);
}
