package com.team.mvc.dao.interf;

import com.team.mvc.entity.CardBalanceEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface cardBalanceDao {
    CardBalanceEntity findByBalanceID(long balanceId);
    CardBalanceEntity findByCardID(long CardID);//+++
    void saveCardBalance( CardBalanceEntity cardBalanceEntity);
    List<CardBalanceEntity> findAllBalance();

    void deleteCardBalancebyCardId(long CardID);
}
