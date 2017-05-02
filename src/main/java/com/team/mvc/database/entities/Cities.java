package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "CITIES")
public class Cities implements Serializable {


    @Id
    @Column(name = "CITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITIES_SEQ")
    @SequenceGenerator(name = "CITIES_SEQ", sequenceName = "CITIES_SEQ")
    private long cityId;

    @Column(name = "CITY_NAME", nullable = false, length = 100, unique = true)
    private String cityName;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    @JsonBackReference(value="person-city")
    public List<Persons> persons = new ArrayList<Persons>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    @JsonBackReference(value = "company-city")
    public List<Companies> companies = new ArrayList<Companies>();


    public Cities() {

    }


    public long getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public List<Persons> getPersons() {
        return persons;
    }

    public List<Companies> getCompanies() {
        return companies;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setPersons(List<Persons> persons) {
        this.persons = persons;
    }

    public void setCompanies(List<Companies> companies) {
        this.companies = companies;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cities cities = (Cities) o;

        if (cityId != cities.cityId) return false;
        if (cityName != null ? !cityName.equals(cities.cityName) : cities.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cityId ^ (cityId >>> 32));
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }
}

