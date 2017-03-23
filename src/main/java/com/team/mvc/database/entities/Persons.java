package com.team.mvc.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
public class Persons {
    private long personId;
    private String firstName;
    private String lastName;
    private long cityId;
    private String mobileNumber;
    private String email;
    private String password;
    private String ssoId;
    private String state;

    @Id
    @Column(name = "PERSON_ID", nullable = false, precision = 0)
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LAST_NAME", nullable = false, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "CITY_ID", nullable = false, precision = 0)
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "MOBILE_NUMBER", nullable = true, length = 20)
    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Basic
    @Column(name = "EMAIL", nullable = false, length = 30)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "PASSWORD", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "SSO_ID", nullable = false, length = 30)
    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    @Basic
    @Column(name = "STATE", nullable = false, length = 30)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persons persons = (Persons) o;

        if (personId != persons.personId) return false;
        if (cityId != persons.cityId) return false;
        if (firstName != null ? !firstName.equals(persons.firstName) : persons.firstName != null) return false;
        if (lastName != null ? !lastName.equals(persons.lastName) : persons.lastName != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(persons.mobileNumber) : persons.mobileNumber != null)
            return false;
        if (email != null ? !email.equals(persons.email) : persons.email != null) return false;
        if (password != null ? !password.equals(persons.password) : persons.password != null) return false;
        if (ssoId != null ? !ssoId.equals(persons.ssoId) : persons.ssoId != null) return false;
        if (state != null ? !state.equals(persons.state) : persons.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (int) (cityId ^ (cityId >>> 32));
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (ssoId != null ? ssoId.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}
