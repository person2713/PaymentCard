package com.team.mvc.database.services;

import com.team.mvc.database.repositories.CardBalanceRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

/**

 */
public class PaymentService {
    @Autowired
    CardBalanceRepository cardBalanceRepository;
    public boolean paymentpossibility(long id, long cost) throws NotFoundException {
      if(cardBalanceRepository.getById(id).getBalance() < cost) {return false;}
      else cardBalanceRepository.getById(id).setBalance(cardBalanceRepository.getById(id).getBalance() - cost); return true;
    }
}
