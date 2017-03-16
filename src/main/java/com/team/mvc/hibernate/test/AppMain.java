package com.team.mvc.hibernate.test;

import com.team.mvc.entity.CitiesEntity;
import com.team.mvc.hibernate.utils.HibernateSessionFactory;
import org.hibernate.Session;

/**
 * Created by Nick on 15.03.2017.
 */
public class AppMain {
    public static void main(String[] args) {
        System.out.println("Hibernate tutorial");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();

        session.beginTransaction();

        CitiesEntity citiesEntity = new CitiesEntity();

        citiesEntity.setCityName("Pavlovsk");

        session.save(citiesEntity);
        session.getTransaction().commit();

        session.close();
    }
}
