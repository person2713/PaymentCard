package com.team.mvc.database.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BUSES")
public class Buses {

    @Id
    @Column(name = "BUS_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BUSES_SEQ")
    @SequenceGenerator(name = "BUSES_SEQ", sequenceName = "BUSES_SEQ")
    private long busId;


    @Column(name = "BUS_NUMBER", nullable = false, length = 20)
    private String busNumber;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private Companies company;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bus")
    public List<Events> events = new ArrayList<Events>();

    @ManyToMany(mappedBy="buses")
    private List<Drivers> drivers = new ArrayList<Drivers>();

    @ManyToMany(mappedBy="busesList")
    private List<Routes> routes = new ArrayList<Routes>();

    public Buses() {
    }


    public long getBusId() {
        return busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public Companies getCompany() {
        return company;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buses buses = (Buses) o;

        if (busId != buses.busId) return false;
        if (company != buses.company) return false;
        if (busNumber != null ? !busNumber.equals(buses.busNumber) : buses.busNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (busId ^ (busId >>> 32));
        result = 31 * result + (busNumber != null ? busNumber.hashCode() : 0);
        return result;
    }
}
