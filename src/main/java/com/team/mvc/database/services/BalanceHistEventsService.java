package com.team.mvc.database.services;

import com.team.mvc.database.mergedEntities.BalanceHistEvents;
import com.team.mvc.database.repositories.BalanceHistEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceHistEventsService {
    @Autowired
    BalanceHistEventsRepository balanceHistEventsRepository;

    public List<BalanceHistEvents> getBalanceHistEventsByCardId(Long card_id)
    {
        return balanceHistEventsRepository.getBalanceHistEventsByCardId(card_id);
    }
}
