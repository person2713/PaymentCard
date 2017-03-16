package com.team.mvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Nick on 15.03.2017.
 */
@Entity
@Table(name = "DRIVERS", schema = "CAPTAIN", catalog = "")
public class DriversEntity {
    private int driverId;

    @Id
    @Column(name = "DRIVER_ID")
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriversEntity that = (DriversEntity) o;

        if (driverId != that.driverId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return driverId;
    }
}
