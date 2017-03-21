package com.team.mvc.entity;

import javax.persistence.*;

/**
 * Created by vit on 21.03.2017.
 */
@Entity
@Table(name = "DRIVERS", schema = "CAPTAIN", catalog = "")
public class DriversEntity {
    private int driverId;
    private int personId;
    private long companyId;

    @Id
    @Column(name = "DRIVER_ID", nullable = false, precision = 0)
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "PERSON_ID", nullable = false, precision = 0)
    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
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

        DriversEntity that = (DriversEntity) o;

        if (driverId != that.driverId) return false;
        if (personId != that.personId) return false;
        if (companyId != that.companyId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = driverId;
        result = 31 * result + personId;
        result = 31 * result + (int) (companyId ^ (companyId >>> 32));
        return result;
    }
}
