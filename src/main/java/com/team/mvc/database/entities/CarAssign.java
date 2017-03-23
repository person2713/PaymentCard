package com.team.mvc.database.entities;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
@Table(name = "CAR_ASSIGN", schema = "CAPTAIN", catalog = "")
public class CarAssign {
    private long assignId;
    private Timestamp dateAssign;
    private long driverId;
    private long busId;
    private long routeId;

    @Id
    @Column(name = "ASSIGN_ID", nullable = false, precision = 0)
    public long getAssignId() {
        return assignId;
    }

    public void setAssignId(long assignId) {
        this.assignId = assignId;
    }

    @Basic
    @Column(name = "DATE_ASSIGN", nullable = true)
    public Timestamp getDateAssign() {
        return dateAssign;
    }

    public void setDateAssign(Timestamp dateAssign) {
        this.dateAssign = dateAssign;
    }

    @Basic
    @Column(name = "DRIVER_ID", nullable = false, precision = 0)
    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "BUS_ID", nullable = false, precision = 0)
    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    @Basic
    @Column(name = "ROUTE_ID", nullable = false, precision = 0)
    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarAssign carAssign = (CarAssign) o;

        if (assignId != carAssign.assignId) return false;
        if (driverId != carAssign.driverId) return false;
        if (busId != carAssign.busId) return false;
        if (routeId != carAssign.routeId) return false;
        if (dateAssign != null ? !dateAssign.equals(carAssign.dateAssign) : carAssign.dateAssign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (assignId ^ (assignId >>> 32));
        result = 31 * result + (dateAssign != null ? dateAssign.hashCode() : 0);
        result = 31 * result + (int) (driverId ^ (driverId >>> 32));
        result = 31 * result + (int) (busId ^ (busId >>> 32));
        result = 31 * result + (int) (routeId ^ (routeId >>> 32));
        return result;
    }
}
