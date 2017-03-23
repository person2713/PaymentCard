package com.team.mvc.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
public class Buses {
    private long busId;
    private String busNumber;
    private long companyId;

    @Id
    @Column(name = "BUS_ID", nullable = false, precision = 0)
    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    @Basic
    @Column(name = "BUS_NUMBER", nullable = false, length = 20)
    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
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

        Buses buses = (Buses) o;

        if (busId != buses.busId) return false;
        if (companyId != buses.companyId) return false;
        if (busNumber != null ? !busNumber.equals(buses.busNumber) : buses.busNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (busId ^ (busId >>> 32));
        result = 31 * result + (busNumber != null ? busNumber.hashCode() : 0);
        result = 31 * result + (int) (companyId ^ (companyId >>> 32));
        return result;
    }
}
