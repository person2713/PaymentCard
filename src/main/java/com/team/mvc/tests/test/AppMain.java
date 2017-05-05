package com.team.mvc.tests.test;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.repositories.CitiesRepository;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AppMain {

        public static void main(String[] args) {
            AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.scan("com.team.mvc.database.repositories");//This will load the configured components UserService, UserRepository,
            ctx.refresh();

            System.out.println(ctx);
        //    UserService userService = ctx.getBean("userService", UserService.class);


            CitiesRepository citiesRepository = ctx.getBean("citiesRepository", CitiesRepository.class);
            System.out.println("Hibernate tutorial");


            Cities citiesEntity = new Cities();

            citiesEntity.setCityName("Pavlovsk");

            citiesRepository.save(citiesEntity);



        }
    }
