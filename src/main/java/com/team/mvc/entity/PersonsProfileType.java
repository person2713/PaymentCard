package com.team.mvc.entity;

/**
 * Created by Nick on 20.03.2017.
 */
public enum PersonsProfileType {

    USER("USER"),
    DRIVER("DRIVER"),
    OWNER("OWNER"),
    ADMIN("ADMIN");

    String personsProfileType;

    private PersonsProfileType(String personsProfileType){
        this.personsProfileType = personsProfileType;
    }

    public String getPersonsProfileType(){
        return personsProfileType;
    }
}
