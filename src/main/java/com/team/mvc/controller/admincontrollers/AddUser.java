package com.team.mvc.controller.admincontrollers;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import org.apache.log4j.Logger;
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
@RequestMapping("/admin/addUser")
public class AddUser {

    private static final Logger logger = Logger.getLogger(com.team.mvc.controller.RegistrationController.class.getName());

    @Autowired
    PersonService personService;

    @Autowired
    CityService cityService;

    @Autowired
    MessageSource messageSource;


    @RequestMapping(method = RequestMethod.GET)
    public String renderAddUserForm(ModelMap model) {
        Persons person = new Persons();
        model.addAttribute("userForm", person);
        return "admin/addUser";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute("userForm") Persons person, BindingResult result) {

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!personService.isPersonsNicknameUnique(person.getPersonId(), person.getNickname())) {
            FieldError nicknameUniqError = new FieldError("person", "nickname", messageSource.getMessage("non.unique.user.nickname", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameUniqError);
            return "admin/addUser";
        } else {
            personService.savePerson(person);
            return "redirect:/admin/allUsers";
        }
    }

    @ModelAttribute("cities")
    public List<Cities> initializeCities() {
        return cityService.getAll();
    }


}
