package com.team.mvc.dao.interf;

import com.team.mvc.entity.BalanceHist;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface balanceHistDao {
    //+ add forei key into entity
    List<BalanceHist> findBalanceHistByCardID(long cardId);
    List<BalanceHist> findBalanceHistByBalanceID(long balance_id);
    BalanceHist findBalanceHistByBalanceHistID (long balanceHistId);
    void saveCardBalance( BalanceHist balanceHistEntity);
    List<BalanceHist> findAllBalance();

    void deleteCardBalancebyBalHistID(long balance_id);
}
