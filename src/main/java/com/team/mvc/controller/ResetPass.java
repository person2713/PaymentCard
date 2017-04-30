package com.team.mvc.controller;

import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

/**

 */
public class ResetPass {
/*
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MessageSource messages;
    @Autowired
    PersonService personService;



    @RequestMapping(value = "/resetPassword/{email}", method = RequestMethod.GET)
    @ResponseBody

    public void    resetPassword(@PathVariable("email") String email) {

        Persons person = personService.findByEmail(email);
        mailSender.send(constructResetTokenEmail(person));}
    private final SimpleMailMessage constructResetTokenEmail(final Persons person) {

      //  final String message = messages.getMessage("We will send an email with a new registration token to your email account",null, locale);
        final SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(person.getEmail());
        email.setSubject("Password");
        email.setText( person.getPassword());
        email.setFrom("trebvit@gmail.com");
        return email;
    }*/
}
