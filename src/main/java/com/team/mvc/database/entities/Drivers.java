package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persons person;

    @Column(name="COMPANY_ID")
    private Long companyId;


    public Drivers() {
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public Persons getPerson() {
        return person;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drivers drivers = (Drivers) o;

        if (driverId != drivers.driverId) return false;
        if (person != null ? !person.equals(drivers.person) : drivers.person != null) return false;
        return companyId != null ? companyId.equals(drivers.companyId) : drivers.companyId == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (driverId ^ (driverId >>> 32));
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        return result;
    }
}
