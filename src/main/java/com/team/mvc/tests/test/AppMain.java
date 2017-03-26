package com.team.mvc.tests.test;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.repositories.CitiesRepository;
import com.team.mvc.tests.utils.HibernateSessionFactory;
import org.hibernate.Session;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**

 */
public class AppMain {

        public static void main(String[] args) {
           /* AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
            ctx.scan("com.team.mvc");//This will load the configured components UserService, UserRepository,
            ctx.refresh();
            System.out.println(ctx);
     /*   //    UserService userService = ctx.getBean("userService", UserService.class);


            CitiesRepository citiesRepository = ctx.getBean("citiesRepository", CitiesRepository.class);
            System.out.println("Hibernate tutorial");


            Cities citiesEntity = new Cities();

            System.out.println(citiesEntity.getCityName().toString());

            citiesRepository.save(citiesEntity);*/





                    System.out.println("Hibernate tutorial");

                    Session session = HibernateSessionFactory.getSessionFactory().openSession();

                    session.beginTransaction();

                    Cities cities = new Cities();

                    cities.setCityName("Pavlovsk");

                    session.save(cities);
                    session.getTransaction().commit();

                    session.close();
                }
            }




