package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.busesDao;
import com.team.mvc.entity.BusesEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class busesDaoImpl  extends AbstractDao<Short,BusesEntity> implements busesDao {
    @Override
    public BusesEntity findById(short busId) {
        return getByKey(busId);
    }

    @Override
    public List<BusesEntity> findByNumber(String busNumber) {
        Query query = getSession().createSQLQuery(
                "select * from BUSES where BUS_NUMBER = :busNumber")
                .addEntity(BusesEntity.class)
                .setParameter("busNumber", "busNumber");
        List result = query.list();
        return result;
    }

    @Override
    public void saveBus(BusesEntity busesEntity) {
        persist(busesEntity);

    }

    @Override
    public void deleteBusbyBusID(short busId) {
        Query query = getSession().createSQLQuery("delete from BUSES where BUS_ID = :busId");
        query.setParameter("busId", busId);
        query.executeUpdate();

    }

    @Override
    public List<BusesEntity> findAllBus() {

        Criteria criteria = createEntityCriteria();
        return (List<BusesEntity>) criteria.list();
    }
}
