package com.team.mvc.dao;


import com.team.mvc.entity.CitiesEntity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.team.mvc.hibernate.utils.HibernateSessionFactory.getSessionFactory;


/**
 * Created by vit on 16.03.2017.
 */
@Repository
public class CitiesDaoImpl  implements CitiesDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public CitiesEntity getCitiesEntity(String citiname) {
        List<CitiesEntity> cities = new ArrayList<CitiesEntity>();

        cities = sessionFactory.getCurrentSession()
                .createQuery("from CitiesEntity where cityName=?")
                .setParameter(0, citiname)
                .list();

        if (cities.size() > 0) {
            return cities.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<CitiesEntity> getCity() {
        List list = getSessionFactory().getCurrentSession().createQuery("from  CitiesEntity ").list();
        return list;
    }
}

