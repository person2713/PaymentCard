package com.team.mvc.controller.admincontrollers;


import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/addcompany")
public class AddCompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CityService cityService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String renderAddNewCompany(ModelMap model) {
        Companies company = new Companies();

        model.addAttribute("companyForm", company);
        return "admin/addcompany";
    }

    @RequestMapping(value = "/newCompany", method = RequestMethod.POST)
    public String saveCompany(@Valid @ModelAttribute("companyForm") Companies company, BindingResult result,
                           ModelMap model) {

        List<FieldError> errors = new ArrayList<>();

        if (result.hasErrors()) {
            return "errorPage";
        }

        if (company.getCompanyName().isEmpty()) {
            FieldError companyNameError = new FieldError("company", "companyName", messageSource.getMessage("NotEmpty.company.name", new String[]{company.getCompanyName()}, Locale.getDefault()));
            errors.add(companyNameError);
        }
        if (!companyService.isCompanyNameUnique((int)company.getCompanyId(), company.getCompanyName())) {
            FieldError companyNameUniqError = new FieldError("company", "companyName", messageSource.getMessage("non.unique.companyname", new String[]{company.getCompanyName()}, Locale.getDefault()));
            errors.add(companyNameUniqError);
        }

        if (company.getCity().equals(null)) {
            FieldError cityError = new FieldError("company", "city", messageSource.getMessage("NotEmpty.company.city", new String[]{company.getCompanyName()}, Locale.getDefault()));
            errors.add(cityError);
        }
        if(!errors.isEmpty()){

            for(FieldError error: errors){
                result.addError(error);
            }
            return "admin/addcompany";
        }


        companyService.saveCompany(company);
        return "success";
    }

    @ModelAttribute("cities")
    public List<Cities> InitializeCities() {
        return cityService.getAll();
    }

}
