package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/admin/allOwners")
public class GetOwners {

    @Autowired
    OwnerService ownerService;

    @Autowired
    CompanyService companyService;

    @Autowired
    CityService cityService;

    @Autowired
    MessageSource messageSource;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getOwners(ModelMap model) {
        model.addAttribute("loggedinuser", GetRole.getPrincipal());
        model.addAttribute("owners", ownerService.getAll());
        return "admin/getOwners";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String showUpdateOwnerForm(@PathVariable("id") long id, Model model) {

        try {
            Owners owner = ownerService.getById(id);
            model.addAttribute("edit", true);
            model.addAttribute("ownerForm", owner);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return "errorPage";
        }
        return "admin/addOwner";
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String deleteOwner(@PathVariable("id") long id) {

        try {
            ownerService.delete(id);
            return "redirect:/admin/allOwners";
        }
        catch (Exception e){
            return "errorPage";
        }

    }

    @RequestMapping(value = "/editOwner", method = RequestMethod.POST)
    public String saveOrUpdateOwner(@ModelAttribute("ownerForm") @Validated Owners owner, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "errorPage";
        }
        if (!ownerService.isOwnerNicknameUnique(owner.getOwnerId(), owner.getPerson().getNickname())) {
            model.addAttribute("edit", true);
            FieldError nicknameUniqError = new FieldError("owner", "person.nickname", messageSource.getMessage("non.unique.owner.nickname", new String[]{owner.getPerson().getNickname()}, Locale.getDefault()));
            result.addError(nicknameUniqError);
            return "admin/addOwner";
        } else {
            ownerService.update(owner);
            return "redirect:/admin/allOwners";
        }
    }

    @ModelAttribute("companies")
    public List<Companies> getAllCompanies() {
        return companyService.getAll();
    }

    @ModelAttribute("cities")
    public List<Cities> getAllCities() {
        return cityService.getAll();
    }

}
