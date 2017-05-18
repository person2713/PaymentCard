package com.team.mvc.controller;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Rollers;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;
import com.team.mvc.log.Const;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
@RequestMapping("/registration")
public class RegistrationController {

    private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

    @Autowired
    PersonService personService;

    @Autowired
    CityService cityService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    RoleService roleService;

    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistration(ModelMap model) {
        Persons person = new Persons();
        model.addAttribute("userForm", person);
        model.addAttribute("edit", false);
        model.addAttribute("isAdmin", GetRole.hasRole("ROLE_ADMIN"));
        return "registration";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("userForm") Persons person, BindingResult result) {

        List<FieldError> listError = new ArrayList<>();

        if (result.hasErrors()) {
            return "errorPage";
        }

        if (!personService.isPersonsNicknameUnique(person.getPersonId(), person.getNickname())) {
            FieldError nicknameUniqError = new FieldError("person", "nickname", messageSource.getMessage("non.unique.user.nickname", new String[]{person.getNickname()}, Locale.getDefault()));
            listError.add(nicknameUniqError);
        }
        if (!personService.isPersonsEmailUnique(person.getPersonId(), person.getEmail())) {
            FieldError emailUniqError = new FieldError("person", "email", messageSource.getMessage("non.unique.user.email", new String[]{person.getEmail()}, Locale.getDefault()));
            listError.add(emailUniqError);
        }
        if (!personService.isPersonsMobileUnique(person.getPersonId(), person.getMobileNumber())) {
            FieldError mobileUniqError = new FieldError("person", "mobileNumber", messageSource.getMessage("non.unique.user.mobileNumber", new String[]{person.getMobileNumber()}, Locale.getDefault()));
            listError.add(mobileUniqError);
        }

        if(!listError.isEmpty()){
            for (FieldError fieldError: listError) {
                result.addError(fieldError);
            }
            return "registration";
        }
        else {
            person.setRole(roleService.findByType("USER"));
            personService.savePerson(person);
            if (Const.DEBUG) {
                if (logger.isDebugEnabled()) {
                    logger.debug("person: id-" + person.getPersonId() +
                            " Nickname-" + person.getNickname() +
                            " Lastname-" + person.getLastName() +
                            " FirstName-" + person.getFirstName() +
                            " Email-" + person.getEmail() +
                            " City-" + person.getCity().getCityName() +
                            " MobileNumber-" + person.getMobileNumber() +
                            " Role-" + person.getRole().getRoleType());
                }
            }
            if (GetRole.hasRole("ROLE_ADMIN"))
                return "redirect:/admin/allUsers";
            else
                return "success";
        }
    }

    @ModelAttribute("cities")
    public List<Cities> initializeCities() {
        return cityService.getAll();
    }


}
