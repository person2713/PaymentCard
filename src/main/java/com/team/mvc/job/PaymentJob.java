package com.team.mvc.job;

import com.team.mvc.database.entities.CardBalance;
import com.team.mvc.database.repositories.CardBalanceRepository;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**

 */
@Service("PaymentJob")
@EnableScheduling
public class PaymentJob {
//    protected void myTask() {
//        System.out.println("This is my task");
//    }
@Autowired
CardBalanceRepository cardBalanceRepository;
  //  @Scheduled(cron ="*/100000 * * * * *")
    public void update() {
        cardBalanceRepository.update();
    }
}

