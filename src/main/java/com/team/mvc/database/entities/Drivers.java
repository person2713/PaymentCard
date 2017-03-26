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
    @Column(name = "PERSON_ID", nullable = false)
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
        int result = (int) (driverId ^ (driverId >>> 32));
        result = 31 * result + (int) (person.hashCode() ^ (person.hashCode() >>> 32));
        result = 31 * result + (int) (company.hashCode() ^ (company.hashCode() >>> 32));
        return result;
    }
}
