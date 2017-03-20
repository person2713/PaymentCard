package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.companiesDao;
import com.team.mvc.entity.CompaniesEntity;

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

    }

    @Override
    public void deleteCompanybyName(String companyName) {

    }

    @Override
    public List<CompaniesEntity> findAllCompany() {
        return null;
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
