package com.team.mvc.dao.interf;

import com.team.mvc.entity.EventsEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface eventsDao {
    EventsEntity findById(long eventId);

    void saveEvent( EventsEntity eventsEntity);

    void deleteEventbyEventID(long eventId);

    List<EventsEntity> findAllEvents();

    List<EventsEntity> findEventByCardID(long cardId);//add to entity

}
