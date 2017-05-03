package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    CityService cityService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    PersonService personService;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @Autowired
    RoleService roleService;



    @Autowired
    RouteService routeService;

    @Autowired
    TypeCardService typeCardService;

    @Autowired
    CardService cardService;

    @RequestMapping(value = "/getlAllUsers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getAllUsers() {
        List<Persons> listPerson = personService.getAllUser();
        Persons person = personService.findByNickname(GetRole.getPrincipal());
        listPerson.remove(person);
        return listPerson;
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUser(ModelMap model) {
        return "admin/editUser";
    }

    @RequestMapping(value = "/editCard", method = RequestMethod.GET)
    public String editCard(ModelMap model) {
        return "admin/editCard";
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getUsers() {
        return personService.getUsers();
    }

    @RequestMapping(value = "/getCards", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Cards> getCards() {
        return cardService.getAll();
    }


    @RequestMapping(value = "/getRoute", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Routes> getRoute() {
        return routeService.getAll();
    }


    @RequestMapping(value = "/getOwners", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getOwners() {
        return personService.getOwners();
    }

    @RequestMapping(value = "/getDrivers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getDrives() {
        return personService.getDrivers();
    }

    @RequestMapping(value = "/getCities", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Cities> getCities() {
        return cityService.getAll();
    }

    @RequestMapping(value = "/getTypeCard", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TypeCard> getTypeCard() {
        return typeCardService.getAll();
    }


    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public
    @ResponseBody
    List<String> getAllUser() {
        return personService.stringPersons();
    }


    @RequestMapping(value = "/getRollers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Rollers> getRollers() {
        return roleService.findAll();
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public
    @ResponseBody
    String deleteUser(@RequestBody List<String> list) {

        for (String nickName : list) {
            personService.deleteByNickName(nickName);
            System.out.println("Delete " + nickName);
        }
        return "Success";
    }

    @RequestMapping(value = "/saveChangesForUsers", method = RequestMethod.POST)
    public
    @ResponseBody
    String saveChangesForUsers(@RequestBody Persons person) {
        System.out.println("blalba " + person.getNickname());
        return "Success changes";
    }


    @RequestMapping(value = "/saveChangesForCards", method = RequestMethod.POST)
    public
    @ResponseBody
    String saveChangesForCards(@RequestBody List<String> list) {
//        cardService.update();
        System.out.println("LIST1");
        for (String str : list) {
            System.out.println(str);
        }
        return "Success changes";
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public
    @ResponseBody
    String addCard(@RequestBody List<String> list) {

        System.out.println("ADDCARD");
        for (String s : list) {
            System.out.println(s);
        }
        if (list.isEmpty()) {
            return "FAILRY";
        } else {
            Cards cards = new Cards();
            cards.setCardName(list.get(0));
            cards.setCardKey(Long.parseLong(list.get(1)));
            cards.setTypeCard(typeCardService.getTypeCardbyStatus("active"));
//            cards.setPerson(personService.findByNickname(list.get(2)));
            cardService.saveCard(cards);
            return "SUCCESS";
        }

    }
}
