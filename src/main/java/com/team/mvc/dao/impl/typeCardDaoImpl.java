package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.typeCardDao;
import com.team.mvc.entity.TypeCardEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 21.03.2017.
 */
public class typeCardDaoImpl extends AbstractDao<Long, TypeCardEntity> implements typeCardDao {
    @Override
    public TypeCardEntity findByTypeCardId(long typeId) {
        return getByKey(typeId);
    }

    @Override
    public TypeCardEntity findByStatus(String status) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("status", status));
        return (TypeCardEntity) criteria.uniqueResult();
    }

    @Override
    public TypeCardEntity findByCardType(String cardType) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("cardType", cardType));
        return (TypeCardEntity) criteria.uniqueResult();
    }

    @Override
    public void saveType(TypeCardEntity typeCardEntity) {
        persist(typeCardEntity);
    }

    @Override
    public void deleteTypebyCardType(String cardType) {
        Query query = getSession().createSQLQuery("delete from TYPE_CARD where CARD_TYPE = :cardType");
        query.setParameter("cardType", cardType);
        query.executeUpdate();
    }

    @Override
    public List<TypeCardEntity> findAllType() {
        Criteria criteria = createEntityCriteria();
        return (List<TypeCardEntity>) criteria.list();
    }
}
