package com.team.mvc.database.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "CITIES")
public class Cities {


    @Id
    @Column(name = "CITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITIES_SEQ")
    @SequenceGenerator(name = "CITIES_SEQ", sequenceName = "CITIES_SEQ")
    private long cityId;

    @Column(name = "CITY_NAME", nullable = false, length = 100, unique = true)
    private String cityName;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    public List<Persons> persons = new ArrayList<Persons>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
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

