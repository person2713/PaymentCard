package com.team.mvc.service.interf;

import com.team.mvc.entity.EventsEntity;

import java.util.List;

/**
 * Created by vit on 22.03.2017.
 */
public interface eventsService {
    EventsEntity findById(long eventId);

    void saveEvent( EventsEntity eventsEntity);

    void deleteEventbyEventID(long eventId);

    List<EventsEntity> findAllEvents();

    List<EventsEntity> findEventByCardID(long cardId);
}
