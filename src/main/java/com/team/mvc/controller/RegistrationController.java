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
        return "registration";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveUser(@Valid Persons person, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "errorPage";
        }

        if(!personService.isPersonsNicknameUnique(person.getPersonId(), person.getNickname())){
            FieldError nicknameError =new FieldError("person","nickname",messageSource.getMessage("non.unique.nickname", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameError);
            return "registration";
        }


        person.setRole(roleService.findByType("USER"));
        personService.savePerson(person);

        return "success";
    }

    @ModelAttribute("cities")
    public List<Cities> InitializeCities(){
        return cityService.getAll();
    }
}
