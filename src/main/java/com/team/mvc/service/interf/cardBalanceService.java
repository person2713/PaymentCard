package com.team.mvc.service.interf;

import com.team.mvc.entity.CardBalanceEntity;

import java.util.List;

/**
 * Created by vit on 22.03.2017.
 */
public interface cardBalanceService {
    CardBalanceEntity findByBalanceID(long balanceId);
    CardBalanceEntity findByCardID(long CardID);//+++
    void saveCardBalance( CardBalanceEntity cardBalanceEntity);
    List<CardBalanceEntity> findAllBalance();
    void updateCardBalance(CardBalanceEntity cardBalanceEntity);
}
