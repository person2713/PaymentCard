package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.companiesDao;
import com.team.mvc.entity.Companies;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class companiesDaoImpl extends AbstractDao<Long,Companies>  implements companiesDao {
    @Override
    public Companies findById(long companyId) {
        return getByKey(companyId);
    }

    @Override
    public void saveCompany(Companies companiesEntity) {
        persist(companiesEntity);
    }

    @Override
    public void deleteCompanybyName(String companyName) {
        Query query = getSession().createSQLQuery("delete from COMPANIES where COMPANY_NAME = :companyName");
        query.setString("companyName", companyName);
        query.executeUpdate();
    }

    @Override
    public List<Companies> findAllCompany() {
        Criteria criteria = createEntityCriteria();
        return (List<Companies>) criteria.list();
    }

    @Override
    public Companies findCompanyByName(String companyName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("companyName", companyName));
        return (Companies) criteria.uniqueResult();
    }

    @Override
    public Companies findCompanyByID(long companyId) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("companyId", companyId));
        return (Companies) criteria.uniqueResult();
    }
}
