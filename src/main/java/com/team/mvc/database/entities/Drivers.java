package com.team.mvc.database.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "DRIVERS")
public class Drivers {


    @Id
    @Column(name = "DRIVER_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "DRIVERS_SEQ")
    @SequenceGenerator(name = "DRIVERS_SEQ", sequenceName = "DRIVERS_SEQ")
    private long driverId;

    @OneToOne
    @JoinColumn(name="PERSON_ID")
    private Persons person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Companies company;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "CAR_ASSIGN",
            joinColumns={@JoinColumn(name = "DRIVER_ID")},
            inverseJoinColumns={@JoinColumn(name = "BUS_ID")})
    private List<Buses> buses = new ArrayList<Buses>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinTable(name = "CAR_ASSIGN",
            joinColumns={@JoinColumn(name = "DRIVER_ID")},
            inverseJoinColumns={@JoinColumn(name = "ROUTE_ID")})
    private List<Routes> routes = new ArrayList<Routes>();


    public Drivers() {
    }

    public long getDriverId() {
        return driverId;
    }

    public Persons getPerson() {
        return person;
    }

    public Companies getCompany() {
        return company;
    }

    public List<Buses> getBuses() {
        return buses;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public void setBuses(List<Buses> buses) {
        this.buses = buses;
    }

    public void setRoutes(List<Routes> routes) {
        this.routes = routes;
    }

    public List<Routes> getRoutes() {
        return routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drivers drivers = (Drivers) o;

        if (driverId != drivers.driverId) return false;
        if (person != drivers.person) return false;
        if (company != drivers.company) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = (int) (driverId ^ (driverId >>> 31));
        result = 31 * result + (int) (person.hashCode() ^ (person.hashCode() >>> 31));
        result = 31 * result + (int) (company.hashCode() ^ (company.hashCode() >>> 31));
        return result;
    }
}
