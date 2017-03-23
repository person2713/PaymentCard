package com.team.mvc.dao.interf;

import com.team.mvc.entity.Companies;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface companiesDao {
    Companies findById(long id);

    void saveCompany( Companies companiesEntity);

    void deleteCompanybyName(String companyName);

    List<Companies> findAllCompany();

    Companies findCompanyByName(String companyName);

    Companies findCompanyByID(long companyId);
}
