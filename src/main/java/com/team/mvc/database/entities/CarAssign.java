package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "CAR_ASSIGN")
public class CarAssign implements Serializable {

    @Id
    @Column(name = "CAR_ASSIGN_ID")
    private Long carAssignId;

    @JsonIgnore
    @Column(name = "DATE_ASSIGN")
    private Timestamp dateAssign;


    @Column(name = "BUS_ID")
    private Long busId;

    @Column(name = "DRIVER_ID")
    private Long driverId;

    @Column(name = "ROUTE_ID")
    private Long routeId;

    public CarAssign() {
    }

    public Long getCarAssignId() {
        return carAssignId;
    }

    public void setCarAssignId(Long carAssignId) {
        this.carAssignId = carAssignId;
    }

    public Timestamp getDateAssign() {
        return dateAssign;
    }

    public void setDateAssign(Timestamp dateAssign) {
        this.dateAssign = dateAssign;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarAssign carAssign = (CarAssign) o;

        if (carAssignId != null ? !carAssignId.equals(carAssign.carAssignId) : carAssign.carAssignId != null)
            return false;
        if (dateAssign != null ? !dateAssign.equals(carAssign.dateAssign) : carAssign.dateAssign != null) return false;
        if (busId != null ? !busId.equals(carAssign.busId) : carAssign.busId != null) return false;
        if (driverId != null ? !driverId.equals(carAssign.driverId) : carAssign.driverId != null) return false;
        return routeId != null ? routeId.equals(carAssign.routeId) : carAssign.routeId == null;
    }

    @Override
    public int hashCode() {
        int result = carAssignId != null ? carAssignId.hashCode() : 0;
        result = 31 * result + (dateAssign != null ? dateAssign.hashCode() : 0);
        result = 31 * result + (busId != null ? busId.hashCode() : 0);
        result = 31 * result + (driverId != null ? driverId.hashCode() : 0);
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        return result;
    }
}
