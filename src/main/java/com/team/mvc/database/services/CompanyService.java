package com.team.mvc.database.services;

import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.repositories.CompaniesRepository;
import com.team.mvc.log.Const;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class CompanyService {

    @Autowired
    CompaniesRepository companiesRepository;

    public void save(Companies company) {
        companiesRepository.save(company);
    }

    public boolean isCompanyNameUnique(Long id, String companyName) {
        Companies company = companiesRepository.findByCompanyName(companyName);
        return (company == null || ((id != null) && (Objects.equals(company.getCompanyId(), id))));
    }

    public boolean isCompanyPhoneNumberUnique(Long id, String phoneNumber) {
        Companies company = companiesRepository.findByPhoneNumber(phoneNumber);
        return (company == null || ((id != null) && (Objects.equals(company.getCompanyId(), id))));
    }

    public List<Companies> getAll() {
        return companiesRepository.getAll();
    }


    public List<Companies> getCompaniesWithoutOwners(){
        return companiesRepository.getCompaniesWithoutOwners();
    }

    public Companies findById(Long id) throws NotFoundException {
        return companiesRepository.getById(id);
    }

    public void delete (Long id) throws NotFoundException {
        companiesRepository.delete(companiesRepository.getById(id));
    }

    public void update(Companies company){
        companiesRepository.update(company);
    }
}
