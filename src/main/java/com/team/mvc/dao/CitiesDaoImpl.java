package com.team.mvc.dao;


        import java.util.List;

        import com.team.mvc.entity.CitiesEntity;
        import org.hibernate.Criteria;
        import org.hibernate.Query;
        import org.hibernate.criterion.Restrictions;
        import org.springframework.stereotype.Repository;

/**
 * Created by vit on 17.03.2017.
 */
@Repository("citiesDao")
public class citiesDaoImpl extends AbstractDao<Integer,CitiesEntity> implements citiesDao {
    @Override
    public CitiesEntity findById(long id) {
        return getByKey((int) id);
    }

    @Override
    public void saveCity(CitiesEntity citiesEntity) {
        persist(citiesEntity);
    }

    @Override
    public void deleteCity(String city_name) {
        Query query = getSession().createSQLQuery("delete from Cities where city_name = :city_name");
        query.setString("city_name", city_name);
        query.executeUpdate();

    }
    @SuppressWarnings("unchecked")
    @Override
    public List<CitiesEntity> findAllCities() {
        Criteria criteria = createEntityCriteria();
        return (List<CitiesEntity>) criteria.list();
    }

    @Override
    public CitiesEntity findCityByName(String city_name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("city_name", city_name));
        return (CitiesEntity) criteria.uniqueResult();
    }
}
