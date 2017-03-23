package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Events;
import org.springframework.stereotype.Repository;

/**

 */
@Repository
public class EventsRepository extends AbstractRepository<Events> {
    public EventsRepository() {
        super(Events.class);
    }
}
