package com.team.mvc.database.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "PERSONS")
public class Persons {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "PERSONS_SEQ")
    @SequenceGenerator(name = "PERSONS_SEQ", sequenceName = "PERSONS_SEQ")
    private long personId;


    @Column(name = "NICKNAME", nullable = false, length = 30, unique = true)
    private String Nickname;


    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;


    @Column(name = "FIRST_NAME", nullable = false, length = 30)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 30)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private Cities city;

    @Column(name = "MOBILE_NUMBER", nullable = true, length = 30)
    private String mobileNumber;

    @Column(name = "EMAIL", nullable = false, length = 30)
    private String email;

    @OneToOne
    @Column(name = "ROLE_ID", nullable = false)
    private Rollers role;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    public List<Cards> cards = new ArrayList<Cards>();

    public Persons() {
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
        if (Nickname != null ? !Nickname.equals(persons.Nickname) : persons.Nickname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 32));
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
