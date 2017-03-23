package com.team.mvc.dao.impl;


        import java.util.List;

        import com.team.mvc.dao.interf.AbstractDao;
        import com.team.mvc.dao.interf.citiesDao;
        import com.team.mvc.entity.Cities;
        import org.hibernate.Criteria;
        import org.hibernate.Query;
        import org.hibernate.criterion.Restrictions;
        import org.springframework.stereotype.Repository;

/**
 * Created by vit on 17.03.2017.
 */
@Repository("citiesDao")
public class citiesDaoImpl extends AbstractDao<Long,Cities> implements citiesDao {


    @Override
    public Cities findById(long cityId) {
        return getByKey(cityId);
    }

    @Override
    public void saveCity(Cities citiesEntity) {
        persist(citiesEntity);

    }

    @Override
    public void deleteCitybyName(String city_name) {

        Query query = getSession().createSQLQuery("delete from CITIES where city_name = :city_name");
        query.setParameter("city_name", city_name);
        query.executeUpdate();



    }

    @Override
    public List<Cities> findAllCities() {
        Criteria criteria = createEntityCriteria();
        return (List<Cities>) criteria.list();
    }

    @Override
    public Cities findCityByName(String city_name) {

            Criteria criteria = createEntityCriteria();
            criteria.add(Restrictions.eq("city_name", city_name));
            return (Cities) criteria.uniqueResult();
    }
}

/*
    @Override
    public Cities findById(long id) {
        return getByKey((int) id);
    }

    @Override
    public void saveCity(Cities citiesEntity) {
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
    public List<Cities> findAllCities() {
        Criteria criteria = createEntityCriteria();
        return (List<Cities>) criteria.list();
    }

    @Override
    public Cities findCityByName(String city_name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cityName", city_name));
        return (Cities) criteria.uniqueResult();
    }

    @Override
    public void add(Cities entity) throws SQLException {

    }

    @Override
    public void update(Cities entity) throws SQLException {

    }

    @Override
    public void remove(Cities entity) throws SQLException {

    }

    @Override
    public Cities get(String key) throws SQLException {
        return null;
    }

    @Override
    public List<Cities> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Cities> getByLikeExpression() throws SQLException {
        return null;
    }*/