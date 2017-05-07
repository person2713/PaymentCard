package com.team.mvc.controller.admincontrollers;


import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Companies;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.CompanyService;
import com.team.mvc.log.Const;
import javassist.NotFoundException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/addcompany")
public class AddCompany {

    private static final Logger logger = Logger.getLogger(AddCompany.class.getName());

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
            FieldError companyNameUniqError = new FieldError("company", "companyName", messageSource.getMessage("non.unique.company.name", new String[]{company.getCompanyName()}, Locale.getDefault()));
            errors.add(companyNameUniqError);
        }

        if (company.getCity()==null) {
            FieldError cityError = new FieldError("company", "city", messageSource.getMessage("NotEmpty.company.city", new Cities[]{company.getCity()}, Locale.getDefault()));
            errors.add(cityError);
        }
        if(!errors.isEmpty()){

            for(FieldError error: errors){
                result.addError(error);
            }
            return "admin/addcompany";
        }


        companyService.saveCompany(company);

        if(Const.DEBUG) {
            if (logger.isDebugEnabled()) {
                logger.debug("company: id-" + company.getCompanyId() +
                        " companyName-" +company.getCompanyName() +
                        " phoneNumber-" + company.getPhoneNumber() +
                        " city"+ company.getCity().getCityName());
            }
        }
        return "/admin/registrationsuccess";
    }

    @RequestMapping(value = { "/edit-company-{companyName}" }, method = RequestMethod.GET)
    public String editCompany(@PathVariable String companyName, ModelMap model) {
        Companies company = companyService.getByCompanyName(companyName);
        model.addAttribute("companyForm", company);
        model.addAttribute("edit", true);
//        model.addAttribute("loggedinuser", getPrincipal());
        return "admin/addcompany";
    }

    @RequestMapping(value = { "/edit-company-{companyName}" }, method = RequestMethod.POST)
    public String updateCompany(@Valid Companies company, BindingResult result,
                             ModelMap model, @PathVariable String companyName) throws NotFoundException {

        if (result.hasErrors()) {
            return "registration";
        }

		/*//Uncomment below 'if block' if you WANT TO ALLOW UPDATING SSO_ID in UI which is a unique key to a User.
		if(!userService.isUserSSOUnique(user.getId(), user.getSsoId())){
			FieldError ssoError =new FieldError("user","ssoId",messageSource.getMessage("non.unique.ssoId", new String[]{user.getSsoId()}, Locale.getDefault()));
		    result.addError(ssoError);
			return "registration";
		}*/

        companyService.updateCompany(company);

        return "/admin/registrationsuccess";
    }


    @ModelAttribute("cities")
    public List<Cities> initializeCities() {
        return cityService.getAll();
    }

}
