package com.team.mvc.dao.interf;

import com.team.mvc.entity.BalanceHist;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface balanceHistDao {
    //+ add forei key into entity
    BalanceHist findBalanceHistByCardID(long card_id);
    BalanceHist findBalanceHistByBalanceID(long balance_id);
    void saveCardBalance( BalanceHist balanceHistEntity);
    List<BalanceHist> findAllBalance();

    void deleteCardBalancebyBalHistID(long balance_id);
}
