package com.team.mvc.dao.impl;


        import java.util.List;

        import com.team.mvc.dao.interf.AbstractDao;
        import com.team.mvc.dao.interf.citiesDao;
        import com.team.mvc.entity.CitiesEntity;
        import org.hibernate.Criteria;
        import org.hibernate.Query;
        import org.hibernate.criterion.Restrictions;
        import org.springframework.stereotype.Repository;

/**
 * Created by vit on 17.03.2017.
 */
@Repository("citiesDao")
public class citiesDaoImpl extends AbstractDao<Long,CitiesEntity> implements citiesDao {


    @Override
    public CitiesEntity findById(long cityId) {
        return getByKey(cityId);
    }

    @Override
    public void saveCity(CitiesEntity citiesEntity) {
        persist(citiesEntity);

    }

    @Override
    public void deleteCitybyName(String city_name) {

        Query query = getSession().createSQLQuery("delete from CITIES where city_name = :city_name");
        query.setParameter("city_name", city_name);
        query.executeUpdate();

    }

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

/*
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
        criteria.add(Restrictions.eq("cityName", city_name));
        return (CitiesEntity) criteria.uniqueResult();
    }

    @Override
    public void add(CitiesEntity entity) throws SQLException {

    }

    @Override
    public void update(CitiesEntity entity) throws SQLException {

    }

    @Override
    public void remove(CitiesEntity entity) throws SQLException {

    }

    @Override
    public CitiesEntity get(String key) throws SQLException {
        return null;
    }

    @Override
    public List<CitiesEntity> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<CitiesEntity> getByLikeExpression() throws SQLException {
        return null;
    }*/