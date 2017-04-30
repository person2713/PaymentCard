package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.Events;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EventsRepository extends AbstractRepository<Events> {
    public EventsRepository() {
        super(Events.class);
    }





}
