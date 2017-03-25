package com.team.mvc.database.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ROUTES")
public class Routes {

    @Id
    @Column(name = "ROUTE_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ROUTES_SEQ")
    @SequenceGenerator(name = "ROUTES_SEQ", sequenceName = "ROUTES_SEQ")
    private long routeId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Companies company;


    @Column(name = "ROUTE_NUMBER", nullable = false, length = 10)
    private String routeNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CAR_ASSIGN",
            joinColumns = { @JoinColumn(name = "ROUTE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "BUS_ID") })
    private List<Buses> buses = new ArrayList<Buses>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CAR_ASSIGN",
            joinColumns = { @JoinColumn(name = "ROUTE_ID") },
            inverseJoinColumns = { @JoinColumn(name = "DRIVER_ID") })
    private List<Drivers> drivers = new ArrayList<Drivers>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Routes routes = (Routes) o;

        if (routeId != routes.routeId) return false;
        if (company != routes.company) return false;
        if (routeNumber != null ? !routeNumber.equals(routes.routeNumber) : routes.routeNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (routeId ^ (routeId >>> 32));
        result = 31 * result + (routeNumber != null ? routeNumber.hashCode() : 0);
        return result;
    }
}
