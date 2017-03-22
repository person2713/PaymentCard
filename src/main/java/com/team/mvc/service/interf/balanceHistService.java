package com.team.mvc.service.interf;

import com.team.mvc.entity.BalanceHistEntity;

import java.util.List;

/**
 * Created by vit on 22.03.2017.
 */
public interface balanceHistService {
    List<BalanceHistEntity> findBalanceHistByCardID(long cardId);
    List<BalanceHistEntity> findBalanceHistByBalanceID(long balance_id);
    BalanceHistEntity findBalanceHistByBalanceHistID (long balanceHistId);
}
