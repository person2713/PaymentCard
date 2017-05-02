package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PERSONS")
public class Persons implements Serializable {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONS_SEQ")
    @SequenceGenerator(name = "PERSONS_SEQ", sequenceName = "PERSONS_SEQ")
    private Integer personId;


    @Column(name = "NICKNAME", nullable = false, length = 30, unique = true)
    private String nickname;


    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;


    @Column(name = "FIRST_NAME", nullable = false, length = 30)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 30)
    private String lastName;

    @ManyToOne(optional = false)
    @JsonManagedReference(value="person-city")
    @JoinColumn(name = "CITY_ID")
    private Cities city;


    @Column(name = "MOBILE_NUMBER", nullable = true, length = 30)
    private String mobileNumber;

    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;

    @OneToOne
    @JoinColumn(name = "ROLE_ID")
    private Rollers role;


    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value="person-cards")
    public List<Cards> cards = new ArrayList<Cards>();

    public Persons() {
    }




    public Integer getPersonId() {
        return personId;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Cities getCity() {
        return city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public Rollers getRole() {
        return role;
    }

    public List<Cards> getCards() {
        return cards;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(Rollers role) {
        this.role = role;
    }

    public void setCards(List<Cards> cards) {
        this.cards = cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persons persons = (Persons) o;

        if (personId != persons.personId) return false;
        if (city != null ? !city.equals(persons.city) : persons.city != null) return false;
        if (firstName != null ? !firstName.equals(persons.firstName) : persons.firstName != null) return false;
        if (lastName != null ? !lastName.equals(persons.lastName) : persons.lastName != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(persons.mobileNumber) : persons.mobileNumber != null)
            return false;
        if (email != null ? !email.equals(persons.email) : persons.email != null) return false;
        if (password != null ? !password.equals(persons.password) : persons.password != null) return false;
        if (nickname != null ? !nickname.equals(persons.nickname) : persons.nickname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 31));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person [personId=" + personId +
                ", Nickname=" + nickname +
                ", firstname=" + firstName +
                ", lastname=" + lastName +
                ", city=" + city.getCityName() +
                ", mobile_number=" + mobileNumber +
                ", email=" + email +
                ", role=" + role.getRoleType() + "]";
    }
}
