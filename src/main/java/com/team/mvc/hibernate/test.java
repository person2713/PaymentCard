package com.team.mvc.hibernate;

import com.team.mvc.database.entities.Buses;
import org.hibernate.Session;

/**
 * Created by Nick on 07.04.2017.
 */
public class test {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Buses bus = new Buses();
//        bus.set


    }
}
