package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Rollers;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;
import com.team.mvc.log.Const;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/allUsers")
public class GetUsers {

    @Autowired
    PersonService personService;

    @Autowired
    CityService cityService;

    @Autowired
    RoleService roleService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getUsers(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("users", personService.getUsers());
        return "admin/getUsers";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") long id, Model model) {

        try {
            Persons user = personService.findById(id);
            model.addAttribute("edit", true);
            model.addAttribute("userForm", user);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return "errorPage";
        }
        return "admin/addUser";
    }


    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") long id) {
        try{
            personService.delete(id);
            return "redirect:/admin/allUsers";
        }
        catch (Exception e){
            return "errorPage";
        }
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("userForm") @Validated Persons person,
                                   BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!personService.isPersonsNicknameUnique(person.getPersonId(), person.getNickname())) {
            model.addAttribute("edit", true);
            FieldError nicknameUniqError = new FieldError("person", "nickname", messageSource.getMessage("non.unique.user.nickname", new String[]{person.getNickname()}, Locale.getDefault()));
            result.addError(nicknameUniqError);
            return "admin/addUser";
        } else {
            personService.update(person);
            return "redirect:/admin/allUsers";
        }
    }


    @ModelAttribute("rollers")
    public List<Rollers> getRollers() {
        return roleService.findAll();
    }

    @ModelAttribute("cities")
    public List<Cities> initializeCities() {
        return cityService.getAll();
    }


}
