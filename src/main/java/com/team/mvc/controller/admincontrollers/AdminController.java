package com.team.mvc.controller.admincontrollers;

import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.Cards;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Routes;
import com.team.mvc.database.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
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
    CardService cardService;

    @Autowired
    RouteService routeService;

    @Autowired
    TypeCardService typeCardService;

    @RequestMapping(value = "/getlAllUsers", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Persons> getAllUsers() {
        List<Persons> listPerson = personService.getAllUser();
        Persons person = personService.findByNickname(GetRole.getPrincipal());
        listPerson.remove(person);
        return listPerson;
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
    List<String> getCities() {
        return cityService.stringCities();
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
    List<String> getRollers() {
        System.out.println("USER ROLE:");
        for (String s: roleService.stringRollers()) {
            System.out.println(s);

        }
        return roleService.stringRollers();
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

    @RequestMapping(value = "/saveChanges", method = RequestMethod.POST)
    public
    @ResponseBody
    String saveChanges(@RequestBody List<String> list) {

        System.out.println("SAVECHANGES");
        for (String s : list) {
            System.out.println(s);
        }
        if (list.isEmpty()) {
            return "FAILRY";
        } else {

            personService.update(Integer.parseInt(list.get(0)), list.get(1), list.get(2), list.get(3),
                    list.get(4), list.get(5), list.get(9), list.get(6));
            System.out.println("Success changes");
            return "Success changes";
        }
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
            cards.setPerson(personService.findByNickname(list.get(2)));
            cardService.saveCard(cards);
////            cards.se
            return "SUCCESS";
        }

    }
}
