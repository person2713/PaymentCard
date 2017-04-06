package com.team.mvc.database.services;

import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.repositories.CompaniesRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyService {

    @Autowired
    CompaniesRepository companiesRepository;

    public void saveCompany (Companies company){
        companiesRepository.save(company);
    }

    public boolean isCompanyNameUnique(Integer id, String companyName) {
        Companies company = companiesRepository.findByCompanyName(companyName);
        return ( company == null || ((id != null) && (company.getCompanyId() == id)));
    }

    public List<Companies> getAll(){
        return companiesRepository.getAll();
    }

    public Companies getByCompanyName(String companyName){
        return companiesRepository.findByCompanyName(companyName);
    }


    public void updateCompany(Companies company) throws NotFoundException {
        Companies entity = companiesRepository.getById(company.getCompanyId());

        if(entity!=null){
            entity.setCompanyId(company.getCompanyId());
            entity.setCompanyName(company.getCompanyName());
            entity.setPhoneNumber(company.getPhoneNumber());
        }
    }
}
