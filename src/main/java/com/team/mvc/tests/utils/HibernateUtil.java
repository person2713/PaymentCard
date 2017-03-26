package com.team.mvc.tests.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Locale;

/**

 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private HibernateUtil(){};

    static{
        try{
            Locale.setDefault(Locale.ENGLISH);
            Configuration configuration = new Configuration().configure();
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());

        }catch(Throwable e){

            throw new ExceptionInInitializerError(e);

        }

    }



    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}