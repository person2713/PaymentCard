package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.BalanceHist;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BalanceHistRepository extends AbstractRepository<BalanceHist> {
    public BalanceHistRepository() {
        super(BalanceHist.class);
    }

    public List getAllHistForCard(Long cardId) {
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("cardId", cardId));
        criteria.addOrder(Order.asc("balanceHistId"));
        return criteria.list();
    }
}
