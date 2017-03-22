package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.eventsDao;
import com.team.mvc.entity.EventsEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class eventsDaoImpl extends AbstractDao<Long,EventsEntity> implements eventsDao {
    @Override
    public EventsEntity findById(long eventId) {
        return getByKey(eventId);
    }

    @Override
    public void saveEvent(EventsEntity eventsEntity) {
        persist(eventsEntity);
    }

    @Override
    public void deleteEventbyEventID(long eventId) {
        Query query = getSession().createSQLQuery("delete from EVENTS where EVENT_ID = :eventId");
        query.setParameter("eventId", eventId);
        query.executeUpdate();
    }

    @Override
    public List<EventsEntity> findAllEvents() {
        Criteria criteria = createEntityCriteria();
        return (List<EventsEntity>) criteria.list();
    }

    @Override
    public List<EventsEntity> findEventByCardID(long cardId) {

        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("CARD_ID", cardId));
        return (List<EventsEntity>) criteria.list();
    }



}
