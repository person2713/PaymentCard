package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.companiesDao;
import com.team.mvc.entity.CompaniesEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public class companiesDaoImpl extends AbstractDao<Long,CompaniesEntity>  implements companiesDao {
    @Override
    public CompaniesEntity findById(long id) {
        return null;
    }

    @Override
    public void saveCompany(CompaniesEntity companiesEntity) {
        persist(companiesEntity);
    }

    @Override
    public void deleteCompanybyName(String companyName) {
        Query query = getSession().createSQLQuery("delete from COMPANIES where COMPANY_NAME = :companyName");
        query.setString("companyName", companyName);
        query.executeUpdate();
    }

    @Override
    public List<CompaniesEntity> findAllCompany() {
        Criteria criteria = createEntityCriteria();
        return (List<CompaniesEntity>) criteria.list();
    }

    @Override
    public CompaniesEntity findCompanyByName(String companyName) {
        return null;
    }

    @Override
    public CompaniesEntity findCompanyByID(long companyId) {
        return null;
    }
}
