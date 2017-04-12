package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "CAR_ASSIGN")
public class CarAssign {

    @Id
    @Column(name = "CAR_ASSIGN_ID")
    private long carAssignId;

    @Column(name = "DATE_ASSIGN")
    private Timestamp dateAssign;

    @ManyToOne
    @JoinColumn(name="BUS_ID")
    @JsonBackReference
    private Buses bus;

    @ManyToOne
    @JoinColumn(name="DRIVER_ID")
    @JsonBackReference
    private Drivers driver;

    @ManyToOne
    @JoinColumn(name="ROUTE_ID")
    @JsonBackReference
    private Routes route;



    public CarAssign() {
    }

    public CarAssign(Timestamp dateAssign) {
        this.dateAssign = dateAssign;
    }


    public void setBus(Buses bus) {
        this.bus = bus;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }

    public void setRoute(Routes route) {
        this.route = route;
    }

    public Buses getBus() {
        return bus;
    }

    public Drivers getDriver() {
        return driver;
    }

    public Routes getRoute() {
        return route;
    }

    public long getCarAssignId() {
        return carAssignId;
    }

    public void setCarAssignId(long carAssignId) {
        this.carAssignId = carAssignId;
    }


    public Timestamp getDateAssign() {
        return new Timestamp(dateAssign.getTime());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarAssign carAssign = (CarAssign) o;

        if (carAssignId != carAssign.carAssignId) return false;
        if (dateAssign != null ? !dateAssign.equals(carAssign.dateAssign) : carAssign.dateAssign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (carAssignId ^ (carAssignId >>> 32));
        result = 31 * result + (dateAssign != null ? dateAssign.hashCode() : 0);
        return result;
    }
}
