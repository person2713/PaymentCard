package com.team.mvc.controller.usercontrollers;


import com.team.mvc.controller.GetRole;
import com.team.mvc.database.entities.*;
import com.team.mvc.database.services.CardsService;
import com.team.mvc.database.services.PersonService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@Controller
@RequestMapping("/user")
public class UserController {

    public static final String ACCOUNT_SID = "AC49a8834042c11bb595f9d9ce94d92446";
    public static final String AUTH_TOKEN = "c197119e48fb7cd9704c3b0352f28fc0";

    private PersonService personService;
    @Autowired
    CardsService cardsService;


    @Autowired
    public void setUserService(PersonService personService) {
        this.personService = personService;
    }


    // list page
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("card", personService.findCradsByNickname(GetRole.getPrincipal()));
        return "user/list";
    }
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") int id, Model model) throws NotFoundException {
        System.out.println("-------------------showUser-------------------" + id);
        Cards cards = personService.findByCardbyID(id);
        System.out.println(cards.toString() + "--------------------------------");
        if (cards == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "User not found");
        }
        model.addAttribute("card", cards);
        return "user/show";
    }

    @RequestMapping(value = "/user/{id}/update", method = RequestMethod.GET)
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
        System.out.println("showUpdateUserForm" + "------------------------------------------------------------------------------------------------------------");
        Cards cards = personService.findByCardbyID(id);
        model.addAttribute("card", cards);
        System.out.println("showUpdateUserForm" + cards.getCardId() + "------------------------------------------------------------------------------------------------------------" );
        return "user/userform";


    }

    @RequestMapping(value = "/user/{id}/money", method = RequestMethod.GET)
    public String showUpdateMoneyForm(@PathVariable("id") int id, Model model) {

        System.out.println("showUpdateUserForm" + "------------------------------------------------------------------------------------------------------------");

        Cards cards = personService.findByCardbyID(id);

        model.addAttribute("card", cards);

        System.out.println("showUpdateUserForm" + cards.getCardId() + "------------------------------------------------------------------------------------------------------------" + cards.getCardBalance().getBalance().toString());


        return "user/moneyform";

    }

    @RequestMapping(value = "/user/{id}/block", method = RequestMethod.GET)
    public RedirectView Block(@PathVariable("id") int id, Model model) {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:9555/user");
        System.out.println("Block" + "------------------------------------------------------------------------------------------------------------");
        cardsService.blockCardById(id);
        System.out.println("Block" +"&&&&&&&&&&&&+ "+"---------------------"+personService.findByNickname(GetRole.getPrincipal()).getMobileNumber()+"---------------"+id+"------------------------------------------------------------------------" );

        try {
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(new PhoneNumber(personService.findByNickname(GetRole.getPrincipal()).getMobileNumber()),
                    new PhoneNumber("+15054040297"),
                    "Уважаемый клиент! Ваша карта №" + id + " была заблокирована! За уточнением деталей обращайтесь по номеру +79003004688 или по электронной почте trebvit@gmail.com").create();
            System.out.println(message.getSid());
        } finally {


            return redirectView;
        }

    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveOrUpdateUser(@ModelAttribute("card") @Validated Cards cards,
                                   BindingResult result, Model model, final RedirectAttributes redirectAttributes) throws NotFoundException {

        System.out.println( "---------===========---------------===============--------------" + cards.getCardId() + "----" + cards.getCardKey());

        if (result.hasErrors()) {

            return "user/userform";
        } else {

            redirectAttributes.addFlashAttribute("css", "success");
            if (cards.isNew()) {
                redirectAttributes.addFlashAttribute("msg", "User added successfully!");
            } else {
                redirectAttributes.addFlashAttribute("msg", "User updated successfully!");
            }
            System.out.println(cards.getCardName().toString() + "---------===========---------------===============--------------" + cards.getCardId() + "----" + cards.getCardKey());
//            cardsService.saveOrUpdate(cards);
            cardsService.updateName(cards.getCardId(), cards.getCardName());

            System.out.println("cardsService.updateName(cards.getCardId(), cards.getCardName());  отработал наверно -----------------");
            // POST/REDIRECT/GET
            return "redirect:/user/user/" + cards.getCardId();

            // POST/FORWARD/GET
            // return "user/list";

        }


    }

    @RequestMapping(value = "/money", method = RequestMethod.POST)
    public String saveOrUpdateMoney(@ModelAttribute("card") @Validated Cards cards,
                                    BindingResult result, Model model, final RedirectAttributes redirectAttributes) throws NotFoundException {

        System.out.println( "---------========saveOrUpdateMoney===---------------===============--------------" + cards.getCardId() + "----" + cards.getCardKey());


            System.out.println("---------===saveOrUpdateMoney========---------------===============--------------" + cards.getCardId() + "----" + cards.getCardKey());

            cardsService.updateMoney(cards.getCardId(), cards.getCardBalance().getBalance());
            System.out.println("cardsService.updateMONEY(cards.getCardId(), cards.getCardName());  отработал наверно -----------------");

            return "redirect:/user/user/" + cards.getCardId();


        }




    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String showAddUserForm() {
        System.out.println("+++++++++++++++++showAddUserForm()+++++++++++++++++++++++++++++");
        return "user/addcard";
    }


    ///////////////////////////////////
    @RequestMapping(value = "/user/{id}/map", method = RequestMethod.GET)
    public String showMap (@PathVariable("id") int id, Model model){
        System.out.println("+++++++++++++++++showAddUserForm()+++++++++++++++++++++++++++++");


        model.addAttribute("events", personService.findByCardbyID(id).getEvents());
        return "user/map";
    }



    @RequestMapping(value = "/user/{id}/mapone", method = RequestMethod.GET)
    public String showMapOne (@PathVariable("id") int id, Model model){
        System.out.println("+++++++++++++++++showAddUserForm()+++++++++++++++++++++++++++++");


        model.addAttribute("event", personService.findEvById(id));
        return "user/swowonemap";
    }



    @RequestMapping(value = "/user/history", method = RequestMethod.GET)
    public String showHistory() {

        System.out.println("+++++++++++++++++showAddUserForm()+++++++++++++++++++++++++++++");

        return "user/history";

    }

    @RequestMapping(value="/user/addUserCard" , method=RequestMethod.POST)
    public String addUserCard(@RequestParam(value="idcard") String idcard, @RequestParam(value="namecard") String namecard){
        System.out.println("+++++++++++++++++addUserCard(@RequestParam String namecard){+++++++++++++++++++++++++++++");
        System.out.println("addUserCard"  + idcard    +   namecard  );

        personService.addUserCard(idcard, namecard);
        return "redirect:/user/user/" +idcard;
    }


    }




