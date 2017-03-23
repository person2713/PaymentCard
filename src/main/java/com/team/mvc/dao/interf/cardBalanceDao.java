package com.team.mvc.dao.interf;

import com.team.mvc.entity.CardBalance;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface cardBalanceDao {
    CardBalance findByBalanceID(long balanceId);
    CardBalance findByCardID(long CardID);//+++
    void saveCardBalance( CardBalance cardBalanceEntity);
    List<CardBalance> findAllBalance();

    void deleteCardBalancebyCardId(long CardID);
}
