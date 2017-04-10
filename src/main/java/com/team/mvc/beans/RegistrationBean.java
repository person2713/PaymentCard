package com.team.mvc.beans;

import com.team.mvc.database.entities.Cities;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Rollers;
import com.team.mvc.database.services.CityService;
import com.team.mvc.database.services.PersonService;
import com.team.mvc.database.services.RoleService;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;

/**

 */
@ManagedBean(name = "registrationBean")
@SessionScoped
public class RegistrationBean {
    public RegistrationBean() {
        persons = new Persons();
        city = new Cities();
        rollers = new Rollers();
    }

    @ManagedProperty("#{personService}")
    private PersonService personService;

    @ManagedProperty("#{cityService}")
    private CityService cityService;

    @ManagedProperty("#{roleService}")
    private RoleService roleService;


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
    /**
     * @return
     */
    public String saveUser() {
        personService.savePerson(persons);
        return "user";

    }
//?facesRedirect=true
    private Rollers rollers;
    private Cities city;

    public List<Cities> getCities() {
        return cityService.getAll();
    }

    public List<Rollers> getRollers() {
        return roleService.findAll();
    }

    public void setRollers(Rollers rollers) {
        this.rollers = rollers;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }





}