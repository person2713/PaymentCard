package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.BalanceHist;
import com.team.mvc.database.entities.Events;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class EventsRepository extends AbstractRepository<Events> {
    public EventsRepository() {
        super(Events.class);
    }

    public List getAllEventsForCard(Long cardId) {
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("cardId", cardId));
        criteria.addOrder(Order.asc("eventId"));
        return criteria.list();
    }

    @Override
    public void update(Events events) {
        getSession().update(events);
    }
}
