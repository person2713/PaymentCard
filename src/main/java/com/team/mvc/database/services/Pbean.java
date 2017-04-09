package com.team.mvc.database.services;

import com.team.mvc.database.entities.CardBalance;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "pbean")
@SessionScoped
public class Pbean {

    @ManagedProperty("#{personService}")
    private PersonService personService;


    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public CardBalance getByNic(String name) {

        return personService.findBalanceByNickname(name);
    }
}
