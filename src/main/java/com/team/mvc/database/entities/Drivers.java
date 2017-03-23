package com.team.mvc.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
public class Drivers {
    private long driverId;
    private long personId;
    private long companyId;

    @Id
    @Column(name = "DRIVER_ID", nullable = false, precision = 0)
    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "PERSON_ID", nullable = false, precision = 0)
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "COMPANY_ID", nullable = false, precision = 0)
    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Drivers drivers = (Drivers) o;

        if (driverId != drivers.driverId) return false;
        if (personId != drivers.personId) return false;
        if (companyId != drivers.companyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (driverId ^ (driverId >>> 32));
        result = 31 * result + (int) (personId ^ (personId >>> 32));
        result = 31 * result + (int) (companyId ^ (companyId >>> 32));
        return result;
    }
}
