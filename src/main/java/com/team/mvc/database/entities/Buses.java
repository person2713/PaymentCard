package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BUSES")
public class Buses {

    @Id
    @Column(name = "BUS_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BUSES_SEQ")
    @SequenceGenerator(name = "BUSES_SEQ", sequenceName = "BUSES_SEQ")
    private Long busId;

    @Column(name = "BUS_NUMBER", nullable = false, length = 20)
    private String busNumber;

    @Column(name="COMPANY_ID")
    private Long companyId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="BUS_ID")
    public Set<Events> events = new HashSet<>();

    public Buses() {
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Set<Events> getEvents() {
        return events;
    }

    public void setEvents(Set<Events> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buses buses = (Buses) o;

        if (busId != null ? !busId.equals(buses.busId) : buses.busId != null) return false;
        if (busNumber != null ? !busNumber.equals(buses.busNumber) : buses.busNumber != null) return false;
        if (companyId != null ? !companyId.equals(buses.companyId) : buses.companyId != null) return false;
        return events != null ? events.equals(buses.events) : buses.events == null;
    }

    @Override
    public int hashCode() {
        int result = busId != null ? busId.hashCode() : 0;
        result = 31 * result + (busNumber != null ? busNumber.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        return result;
    }
}
