package com.team.mvc.beans;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**

 */
@ManagedBean(name = "registrationBean")
@ViewScoped
public class RegistrationBean {
    public RegistrationBean() {
        persons = new Persons();
    }

    @ManagedProperty("#{personService}")
    private PersonService personService;

    @ManagedProperty("#{cityService}")
    private CityService cityService;

    @ManagedProperty("#{roleService}")
    private  RoleService roleService;




    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    public CityService getCityService() {
        return cityService;
    }

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

   private Persons persons;

    public Persons getPersons() {
        return persons;
    }

    public void setPersons(Persons persons) {
        this.persons = persons;
    }

    public void saveUser(){
        personService.savePerson(persons);

    }

    private Cities cities;


}
