package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.eventsDao;
import com.team.mvc.entity.EventsEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class eventsDaoImpl extends AbstractDao<Long,EventsEntity> implements eventsDao {
    @Override
    public EventsEntity findById(long eventId) {
        return null;
    }

    @Override
    public void saveEvent(EventsEntity eventsEntity) {

    }

    @Override
    public void deleteEventbyEventID(long eventId) {

    }

    @Override
    public List<EventsEntity> findAllEvents() {
        return null;
    }

    @Override
    public EventsEntity findEventByCardID(long cardId) {
        return null;
    }

    @Override
    public EventsEntity findEventByEventID(long eventId) {
        return null;
    }
}
