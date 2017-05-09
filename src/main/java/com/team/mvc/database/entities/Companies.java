package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "COMPANIES")
public class Companies {


    @Id
    @Column(name = "COMPANY_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPANIES_SEQ")
    @SequenceGenerator(name = "COMPANIES_SEQ", sequenceName = "COMPANIES_SEQ")
    private Long companyId;

    @Column(name = "COMPANY_NAME", nullable = false, length = 30)
    private String companyName;

    @Column(name = "PHONE_NUMBER", length = 30)
    private String phoneNumber;


    @Column(name = "COMP_BALANCE")
    private BigDecimal compBalance;

    @ManyToOne(optional = false)
    @JoinColumn(name = "CITY_ID")
    private Cities city;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPANY_ID")
    public Set<Buses> buses = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPANY_ID")
    private Set<Drivers> drivers = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="COMPANY_ID")
    public Set<Routes> routes = new HashSet<>();

    public Companies() {
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getCompBalance() {
        return compBalance;
    }

    public void setCompBalance(BigDecimal compBalance) {
        this.compBalance = compBalance;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Set<Buses> getBuses() {
        return buses;
    }

    public void setBuses(Set<Buses> buses) {
        this.buses = buses;
    }

    public Set<Drivers> getDrivers() {
        return drivers;
    }

    public void setDrivers(Set<Drivers> drivers) {
        this.drivers = drivers;
    }

    public Set<Routes> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Routes> routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Companies companies = (Companies) o;

        if (companyId != null ? !companyId.equals(companies.companyId) : companies.companyId != null) return false;
        if (companyName != null ? !companyName.equals(companies.companyName) : companies.companyName != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(companies.phoneNumber) : companies.phoneNumber != null)
            return false;
        if (compBalance != null ? !compBalance.equals(companies.compBalance) : companies.compBalance != null)
            return false;
        if (city != null ? !city.equals(companies.city) : companies.city != null) return false;
        if (buses != null ? !buses.equals(companies.buses) : companies.buses != null) return false;
        if (drivers != null ? !drivers.equals(companies.drivers) : companies.drivers != null) return false;
        return routes != null ? routes.equals(companies.routes) : companies.routes == null;
    }

    @Override
    public int hashCode() {
        int result = companyId != null ? companyId.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (compBalance != null ? compBalance.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (buses != null ? buses.hashCode() : 0);
        result = 31 * result + (drivers != null ? drivers.hashCode() : 0);
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        return result;
    }
}

