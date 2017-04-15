package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "COMPANIES")
public class Companies {


    @Id
    @Column(name = "COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANIES_SEQ")
    @SequenceGenerator(name = "COMPANIES_SEQ", sequenceName = "COMPANIES_SEQ")
    private long companyId;

    @Column(name = "COMPANY_NAME", nullable = false, length = 30)
    private String companyName;

    @Column(name = "PHONE_NUMBER", length = 30)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CITY_ID")
    @JsonBackReference
    private Cities city;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @JsonManagedReference
    public List<Owners> owners = new ArrayList<Owners>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @JsonManagedReference
    public List<Buses> buses = new ArrayList<Buses>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @JsonManagedReference
    private List<Drivers> drivers = new ArrayList<Drivers>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
    @JsonManagedReference
    public List<Routes> routes = new ArrayList<Routes>();

    public Companies() {
    }

    public String getCityName(){
        return city.getCityName();
    }

    public long getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Cities getCity() {
        return city;
    }

    public List<Buses> getBuses() {
        return buses;
    }

    public List<Drivers> getDrivers() {
        return drivers;
    }

    public List<Routes> getRoutes() {
        return routes;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public void setBuses(List<Buses> buses) {
        this.buses = buses;
    }

    public void setDrivers(List<Drivers> drivers) {
        this.drivers = drivers;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }

    public List<Owners> getOwners() {
        return owners;
    }

    public void setOwners(List<Owners> persons) {
        this.owners = persons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Companies companies = (Companies) o;

        if (companyId != companies.companyId) return false;
        if (companyName != null ? !companyName.equals(companies.companyName) : companies.companyName != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(companies.phoneNumber) : companies.phoneNumber != null)
            return false;
        if (city != null ? !city.equals(companies.city) : companies.city != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (companyId ^ (companyId >>> 32));
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
