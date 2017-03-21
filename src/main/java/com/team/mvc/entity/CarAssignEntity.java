package com.team.mvc.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by vit on 21.03.2017.
 */
@Entity
@Table(name = "CAR_ASSIGN", schema = "CAPTAIN", catalog = "")
public class CarAssignEntity {
    private int assignId;
    private Time dateAssign;
    private int driverId;
    private short busId;
    private int routeId;

    @Id
    @Column(name = "ASSIGN_ID", nullable = false, precision = 0)
    public int getAssignId() {
        return assignId;
    }

    public void setAssignId(int assignId) {
        this.assignId = assignId;
    }

    @Basic
    @Column(name = "DATE_ASSIGN", nullable = true)
    public Time getDateAssign() {
        return dateAssign;
    }

    public void setDateAssign(Time dateAssign) {
        this.dateAssign = dateAssign;
    }

    @Basic
    @Column(name = "DRIVER_ID", nullable = false, precision = 0)
    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    @Basic
    @Column(name = "BUS_ID", nullable = false, precision = 0)
    public short getBusId() {
        return busId;
    }

    public void setBusId(short busId) {
        this.busId = busId;
    }

    @Basic
    @Column(name = "ROUTE_ID", nullable = false, precision = 0)
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarAssignEntity that = (CarAssignEntity) o;

        if (assignId != that.assignId) return false;
        if (driverId != that.driverId) return false;
        if (busId != that.busId) return false;
        if (routeId != that.routeId) return false;
        if (dateAssign != null ? !dateAssign.equals(that.dateAssign) : that.dateAssign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assignId;
        result = 31 * result + (dateAssign != null ? dateAssign.hashCode() : 0);
        result = 31 * result + driverId;
        result = 31 * result + (int) busId;
        result = 31 * result + routeId;
        return result;
    }
}
