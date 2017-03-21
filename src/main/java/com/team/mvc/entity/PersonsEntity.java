package com.team.mvc.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "PERSONS")
public class PersonsEntity {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_seq_persons")
    @SequenceGenerator(name = "id_seq_persons", sequenceName = "PERSONS_SEQ")
    private int personId;

    @Column(name="FIRST_NAME", nullable=false)
    private String firstName;

    @Column(name="LAST_NAME", nullable=false)
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID", nullable = false)
    private CitiesEntity city;

    @Column(name = "MOBILE_NUMBER", length = 50)
    private String mobileNumber;

    @Column(name = "EMAIL", length = 50, nullable = false)
    private String email;

    @Column(name="PASSWORD", nullable=false)
    private String password;

    @Column(name="SSO_ID", unique=true, nullable=false)
    private String ssoId;

    @Column(name="STATE", nullable=false)
    private String state=State.ACTIVE.getState();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "PERSONS_PERSONS_PROFILE",
            joinColumns = { @JoinColumn(name = "PERSON_ID") },
            inverseJoinColumns = { @JoinColumn(name = "PERSON_PROFILE_ID") })
    private Set<PersonsProfile> personsProfiles = new HashSet<PersonsProfile>();

    public Set<PersonsProfile> getPersonsProfiles() {
        return personsProfiles;
    }

    public void setPersonsProfiles(Set<PersonsProfile> personsProfiles) {
        this.personsProfiles = personsProfiles;
    }

    public String getSsoId() {
        return ssoId;
    }

    public void setSsoId(String ssoId) {
        this.ssoId = ssoId;
    }

    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public CitiesEntity getCity() {
        return city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


    public String getState() {
        return state;
    }


    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCity(CitiesEntity city) {
        this.city = city;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonsEntity that = (PersonsEntity) o;

        if (personId != that.personId) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (mobileNumber != null ? !mobileNumber.equals(that.mobileNumber) : that.mobileNumber != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (mobileNumber != null ? mobileNumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
