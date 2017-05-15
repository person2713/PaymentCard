package com.team.mvc.converter;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.services.CompanyService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter implements Converter<Object, Companies> {

    @Autowired
    CompanyService companyService;

    public Companies convert(Object element) {
        Long id = Long.parseLong((String) element);
        Companies company = null;
        try {
            company = companyService.findById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return company;
    }
}
