package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.*;
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
@RequestMapping("/admin/addCompany")
public class AddCompany {

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
        return "admin/addCompany";
    }

    @RequestMapping(value = "/newCompany", method = RequestMethod.POST)
    public String saveCompany(@Valid @ModelAttribute("companyForm") Companies company, BindingResult result) {

        List<FieldError> listError = new ArrayList<>();

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!companyService.isCompanyNameUnique(company.getCompanyId(), company.getCompanyName())) {
            FieldError companyNameUniqError = new FieldError("company", "companyName", messageSource.getMessage("non.unique.company.name", new String[]{company.getCompanyName()}, Locale.getDefault()));
            listError.add(companyNameUniqError);
        }
        if(!companyService.isCompanyPhoneNumberUnique(company.getCompanyId(), company.getPhoneNumber())){
            FieldError companyPhoneNumberUniq = new FieldError("company", "phoneNumber", messageSource.getMessage("non.unique.company.phoneNumber", new String[]{company.getPhoneNumber()}, Locale.getDefault()));
            listError.add(companyPhoneNumberUniq);
        }
        if(!listError.isEmpty()){
            for (FieldError fieldError: listError) {
                result.addError(fieldError);
            }
            return "admin/addCompany";
        }
        else {
            companyService.save(company);
            return "redirect:/admin/allCompanies";
        }
    }

    @ModelAttribute("cities")
    public List<Cities> getAllCities() {
        return cityService.getAll();
    }

}
