package com.team.mvc.service.interf;

import com.team.mvc.entity.CompaniesEntity;

import java.util.List;

/**
 * Created by vit on 22.03.2017.
 */
public interface companiesService {
    CompaniesEntity findById(long id);

    void saveCompany( CompaniesEntity companiesEntity);

    void deleteCompanybyName(String companyName);

    List<CompaniesEntity> findAllCompany();

    CompaniesEntity findCompanyByName(String companyName);

    CompaniesEntity findCompanyByID(long companyId);
}
