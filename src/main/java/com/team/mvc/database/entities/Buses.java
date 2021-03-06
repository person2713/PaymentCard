package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.jboss.marshalling.serial.Serial;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BUSES")
public class Buses implements Serializable {

    @Id
    @Column(name = "BUS_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUSES_SEQ")
    @SequenceGenerator(name = "BUSES_SEQ", sequenceName = "BUSES_SEQ", allocationSize=1)
    private Long busId;

    @Column(name = "BUS_NUMBER", nullable = false, length = 20)
    private String busNumber;

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUS_ID")
    public Set<Events> events = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "BUS_ID")
    public Set<CarAssign> carAssigns = new HashSet<>();


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

    public Set<CarAssign> getCarAssigns() {
        return carAssigns;
    }

    public void setCarAssigns(Set<CarAssign> carAssigns) {
        this.carAssigns = carAssigns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Buses buses = (Buses) o;

        if (busId != null ? !busId.equals(buses.busId) : buses.busId != null) return false;
        if (busNumber != null ? !busNumber.equals(buses.busNumber) : buses.busNumber != null) return false;
        if (companyId != null ? !companyId.equals(buses.companyId) : buses.companyId != null) return false;
        if (events != null ? !events.equals(buses.events) : buses.events != null) return false;
        return carAssigns != null ? carAssigns.equals(buses.carAssigns) : buses.carAssigns == null;
    }

    @Override
    public int hashCode() {
        int result = busId != null ? busId.hashCode() : 0;
        result = 31 * result + (busNumber != null ? busNumber.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        result = 31 * result + (carAssigns != null ? carAssigns.hashCode() : 0);
        return result;
    }
}
