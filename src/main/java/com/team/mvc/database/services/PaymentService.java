package com.team.mvc.database.services;

import com.team.mvc.database.repositories.CardBalanceRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;


public class PaymentService {
    @Autowired
    CardBalanceRepository cardBalanceRepository;
    public boolean paymentpossibility(long id, BigDecimal cost) throws NotFoundException {
      if(cardBalanceRepository.getById(id).getBalance().compareTo(cost)<0) return false;
      else cardBalanceRepository.getById(id).setBalance(cardBalanceRepository.getById(id).getBalance().subtract(cost)); return true;
    }
}
