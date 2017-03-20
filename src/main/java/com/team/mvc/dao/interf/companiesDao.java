package com.team.mvc.dao.interf;

import com.team.mvc.entity.CompaniesEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface companiesDao {
    CompaniesEntity findById(long id);

    void saveCompany( CompaniesEntity companiesEntity);

    void deleteCompanybyName(String companyName);

    List<CompaniesEntity> findAllCompany();

    CompaniesEntity findCompanyByName(String companyName);

    CompaniesEntity findCompanyByID(long companyId);
}
