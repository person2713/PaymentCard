package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    @JsonBackReference
    private Companies company;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "driver")
    @JsonManagedReference
    private List<CarAssign> carAssign = new ArrayList<>();


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


    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public List<CarAssign> getCarAssign() {
        return carAssign;
    }

    public void setCarAssign(List<CarAssign> carAssign) {
        this.carAssign = carAssign;
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
