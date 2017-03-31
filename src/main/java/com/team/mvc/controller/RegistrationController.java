package com.team.mvc.controller;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;
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
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    PersonService personService;

    @Autowired
    RoleService roleService;

    @Autowired
    CityService cityService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String renderRegistration(ModelMap model) {
        Persons person = new Persons();

        model.addAttribute("userForm", person);
        model.addAttribute("edit", false);
//        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("userForm") Persons person, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "errorPage";
        }

        if (person.getNickname().isEmpty()) {
            FieldError nicknameError = new FieldError("person", "nickname", messageSource.getMessage("NotEmpty.person.nickname", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameError);
            return "registration";
        }

        if (!personService.isPersonsNicknameUnique(person.getPersonId(), person.getNickname())) {
            FieldError nicknameError = new FieldError("person", "nickname", messageSource.getMessage("non.unique.nickname", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameError);
            return "registration";
        }


        if (person.getPassword().isEmpty()) {
            FieldError nicknameError = new FieldError("person", "password", messageSource.getMessage("NotEmpty.person.password", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameError);
            return "registration";
        }

        if (person.getFirstName().isEmpty()) {
            FieldError nicknameError = new FieldError("person", "firstName", messageSource.getMessage("NotEmpty.person.firstName", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameError);
            return "registration";
        }

        if (person.getLastName().isEmpty()) {
            FieldError nicknameError = new FieldError("person", "lastName", messageSource.getMessage("NotEmpty.person.lastName", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameError);
            return "registration";
        }

        if (person.getEmail().isEmpty()) {
            FieldError nicknameError = new FieldError("person", "email", messageSource.getMessage("NotEmpty.person.email", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameError);
            return "registration";
        }

        if (person.getCity().equals(null)) {
            FieldError nicknameError = new FieldError("person", "city", messageSource.getMessage("NotEmpty.person.city", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameError);
            return "registration";
        }
        person.setRole(roleService.findByType("USER"));
        personService.savePerson(person);

        return "success";
    }

    @ModelAttribute("cities")
    public List<Cities> InitializeCities() {
        return cityService.getAll();
    }
}
