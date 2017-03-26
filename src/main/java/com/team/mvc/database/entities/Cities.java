package com.team.mvc.database.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "CITIES")
public class Cities {



    private long cityId;


    private String cityName;



    private List<Persons> persons ;


    private List<Companies> companies;


    public Cities() {

    }

    @Id
    @Column(name = "CITY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CITIES_SEQ")
    @SequenceGenerator(name = "CITIES_SEQ", sequenceName = "CITIES_SEQ")
    public long getCityId() {
        return cityId;
    }

    @Column(name = "CITY_NAME", nullable = false, length = 100, unique = true)
    public String getCityName() {
        return cityName;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    public List<Persons> getPersons() {
        return persons;
    }
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "city")
    public List<Companies> getCompanies() {
        return companies;
    }

    public void setCityId(long cityId) {
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
