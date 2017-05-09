package com.team.mvc.database.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "DRIVERS")
public class Drivers {


    @Id
    @Column(name = "DRIVER_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DRIVERS_SEQ")
    @SequenceGenerator(name = "DRIVERS_SEQ", sequenceName = "DRIVERS_SEQ")
    private long driverId;

    @OneToOne
    @JoinColumn(name = "PERSON_ID")
    private Persons person;

    @Column(name = "COMPANY_ID")
    private Long companyId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "DRIVER_ID")
    public Set<CarAssign> carAssigns = new HashSet<>();


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

        Drivers drivers = (Drivers) o;

        if (driverId != drivers.driverId) return false;
        if (person != null ? !person.equals(drivers.person) : drivers.person != null) return false;
        if (companyId != null ? !companyId.equals(drivers.companyId) : drivers.companyId != null) return false;
        return carAssigns != null ? carAssigns.equals(drivers.carAssigns) : drivers.carAssigns == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (driverId ^ (driverId >>> 32));
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (carAssigns != null ? carAssigns.hashCode() : 0);
        return result;
    }
}
