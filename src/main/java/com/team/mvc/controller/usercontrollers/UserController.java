package com.team.mvc.controller.usercontrollers;


import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.*;
import com.team.mvc.database.mergedEntities.BalanceHistEvents;
import com.team.mvc.database.services.*;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Locale;


@Controller
@RequestMapping("/user")
public class UserController {

    public static final String ACCOUNT_SID = "AC49a8834042c11bb595f9d9ce94d92446";
    public static final String AUTH_TOKEN = "c197119e48fb7cd9704c3b0352f28fc0";

    private PersonService personService;
    @Autowired
    CardsService cardsService;
    @Autowired
    SendSMSMessageService sendSMSMessageService;
    @Autowired
    SendEMAILMessageService sendEMAILMessageService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    BalanceHistEventsService balanceHistEventsService;

    @Autowired
    public void setUserService(PersonService personService) {
        this.personService = personService;
    }


    // list page
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
       try{
        model.addAttribute("card", personService.findCradsByNickname(GetRole.getPrincipal()));
        return "user/list";}
       catch (Exception E){return "errorPage";}
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Long id, Model model) throws NotFoundException {
        try {
//            System.out.println("-------------------showUser-------------------" + id);
            Cards card = cardsService.findById(id);


            model.addAttribute("card", card);


            List<BalanceHistEvents> objects=balanceHistEventsService.getBalanceHistEventsByCardId(id);
            model.addAttribute("values", objects);
            return "user/show";
        } catch (Exception E) {
            return "errorPage";
        }
    }

    @RequestMapping(value = "/user/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
      try{  System.out.println("showUpdateUserForm" + "------------------------------------------------------------------------------------------------------------");
        Cards cards = personService.findByCardbyID(id);
        model.addAttribute("card", cards);
        System.out.println("showUpdateUserForm" + cards.getCardId() + "------------------------------------------------------------------------------------------------------------");
        return "user/userform";}
      catch (Exception E){return "errorPage";}


    }

    @RequestMapping(value = "/user/{id}/money", method = RequestMethod.GET)
    public String showUpdateMoneyForm(@PathVariable("id") int id, Model model) {
try{
        System.out.println("showUpdateUserForm" + "------------------------------------------------------------------------------------------------------------");

        Cards cards = personService.findByCardbyID(id);

        model.addAttribute("card", cards);


        return "user/moneyform";}
catch (Exception E){return "errorPage";}

    }

    @RequestMapping(value = "/user/{id}/block", method = RequestMethod.GET)
    public String Block(@PathVariable("id") int id, Model model) {
        try{
        System.out.println("Block" + "------------------------------------------------------------------------------------------------------------");
        cardsService.blockCardById(id);}
        catch (Exception E){return "errorPage";}
        System.out.println("Block" + "&&&&&&&&&&&&+ " + "---------------------" + personService.findByNickname(GetRole.getPrincipal()).getMobileNumber() + "---------------" + id + "------------------------------------------------------------------------");

        sendSMSMessageService.SendMessage(personService.findByNickname(GetRole.getPrincipal()).getMobileNumber(),
                                    "Уважаемый клиент! Ваша карта №" + cardsService.findById(id).getCardKey() + " была заблокирована! За уточнением деталей обращайтесь по номеру +79003004688 или по электронной почте trebvit@gmail.com");
        sendEMAILMessageService.SendMessage(personService.findByNickname(GetRole.getPrincipal()).getEmail(),"Уважаемый клиент! Ваша карта №" + cardsService.findById(id).getCardKey() + " была заблокирована! За уточнением деталей обращайтесь по номеру +79003004688 или по электронной почте trebvit@gmail.com");
        return "redirect:/user";

    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("card") @Validated Cards cards,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) throws NotFoundException {



        if (result.hasErrors()) {

            return "user/userform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (cards.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "Имя карты обновлено!");
            }
            System.out.println(cards.getCardName().toString() + "---------===========---------------===============--------------" + cards.getCardId() + "----" + cards.getCardKey());
//            cardsService.saveOrUpdate(cards);
            try{
            cardsService.updateName(cards.getCardId(), cards.getCardName());

            System.out.println("cardsService.updateName(cards.getCardId(), cards.getCardName());  отработал наверно -----------------");
            // POST/REDIRECT/GET
            return "redirect:/user";}
            catch (Exception E){return "errorPage";}

            // POST/FORWARD/GET
            // return "user/list";

        }


    }

    @RequestMapping(value = "/money", method = RequestMethod.POST)
    public String saveOrUpdateMoney(@ModelAttribute("card") @Validated Cards cards,
                                          BindingResult result, Model model, final RedirectAttributes redirectAttributes) throws NotFoundException {

        System.out.println("---------========saveOrUpdateMoney===---------------===============--------------" + cards.getCardId() + "----" + cards.getCardKey());


        System.out.println("---------===saveOrUpdateMoney========---------------===============--------------" + cards.getCardId() + "----" + cards.getCardKey());
try{
        cardsService.updateMoney(cards.getCardId(), cards.getCardBalance().getBalance());
        System.out.println("cardsService.updateMONEY(cards.getCardId(), cards.getCardName());  отработал наверно -----------------");

        return "redirect:/user";}
catch (Exception E){return "errorPage";}


    }


    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String showAddUserForm() {
        System.out.println("+++++++++++++++++showAddUserForm()+++++++++++++++++++++++++++++");
        return "user/addcard";
    }


    ///////////////////////////////////
    @RequestMapping(value = "/user/{id}/map", method = RequestMethod.GET)
    public String showMap(@PathVariable("id") int id, Model model) {
        System.out.println("+++++++++++++++++showAddUserForm()+++++++++++++++++++++++++++++");


       try{ model.addAttribute("events", personService.findByCardbyID(id).getEvents());
        return "user/map";}
       catch (Exception E){return "errorPage";}
    }


    @RequestMapping(value = "/user/{id}/mapone", method = RequestMethod.GET)
    public String showMapOne(@PathVariable("id") int id, Model model) {
        System.out.println("+++++++++++++++++showAddUserForm()+++++++++++++++++++++++++++++");

try{
        model.addAttribute("event", personService.findEvById(id));
        return "user/swowonemap";}
catch (Exception E){return "errorPage";}
    }





    @RequestMapping(value = "/user/addUserCard", method = RequestMethod.POST)
    public String addUserCard(@RequestParam(value = "idcard") String idcard, @RequestParam(value = "namecard") String namecard, Model model) {

try{
        Cards card=cardsService.findByCardKey(Long.valueOf(idcard));
        if (card==null) {
            model.addAttribute("flag", true);
            return "user/addcard";
        }
       if(card.getPersonId()!=null&&!card.getPersonId().equals(0L)){
            model.addAttribute("flag", true);
            return "user/addcard";
        }
        else {
            System.out.println("+++++++++++++++++addUserCard(@RequestParam String namecard){+++++++++++++++++++++++++++++");
            System.out.println("addUserCard" + idcard + namecard);
            personService.addUserCard(idcard, namecard);

            return "redirect:/user";
        }

    }
catch (Exception E){return "errorPage";}



    }

    @ModelAttribute("username1")
    public String getUsername() {
        return GetRole.getPrincipal();
    }

    @ModelAttribute("id_user")
    public Long getUserID() {
        return personService.findByNickname(GetRole.getPrincipal()).getPersonId();
    }


    @RequestMapping(value = "/user/{id}/info", method = RequestMethod.GET)
    public String showUpdUserForm(@PathVariable("id") Long id, Model model) {
        System.out.println("showUpdateUserForm" + "------------------------------------------------------------------------------------------------------------");
        Persons persons = null;
        try {
            persons = personService.findById(id);

        model.addAttribute("person", persons);

        return "user/change_user";
        } catch (Exception E){return "errorPage";}

    }


    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("person") @Validated Persons persons,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) throws NotFoundException {



try{
        personService.updatePerson(persons.getPersonId(),persons.getFirstName(),persons.getLastName(),persons.getMobileNumber());



        return "redirect:/user";}
catch (Exception E){return "errorPage";}

    }


    }







