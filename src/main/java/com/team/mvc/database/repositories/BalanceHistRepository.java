package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.BalanceHist;
import com.team.mvc.database.entities.CarAssign;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class BalanceHistRepository extends AbstractRepository<BalanceHist> {
    public BalanceHistRepository() {
        super(BalanceHist.class);
    }

    @Autowired
    public SessionFactory sessionFactoryZ;

    @Override
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List getAllHistForCard(Long cardId) {
        Criteria criteria = createEntityCriteria().add(Restrictions.eq("cardId", cardId));
//        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.addOrder(Order.asc("balanceHistId"));
        return criteria.list();
    }

    @Override
    public List<BalanceHist> getAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("balanceHistId"));
        return criteria.list();
    }

    @Override
    public void update(BalanceHist balanceHist) {
        getSession().update(balanceHist);
    }
}
