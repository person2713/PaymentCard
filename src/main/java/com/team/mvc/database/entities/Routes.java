package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "ROUTES")
public class Routes {

    @Id
    @Column(name = "ROUTE_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ROUTES_SEQ")
    @SequenceGenerator(name = "ROUTES_SEQ", sequenceName = "ROUTES_SEQ")
    private long routeId;


    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    @JsonBackReference
    private Companies company;

    @Column(name="ROUTE_PRICE", nullable = false)
    private BigDecimal routePrice;

    @Column(name = "ROUTE_NUMBER", nullable = false, length = 10)
    private String routeNumber;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    @JsonManagedReference
    private List<CarAssign> carAssign = new ArrayList<>();


    public void setRoutePrice(BigDecimal routePrice) {
        this.routePrice = routePrice;
    }

    public BigDecimal getRoutePrice() {
        return routePrice;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public void setCarAssign(List<CarAssign> carAssign) {
        this.carAssign = carAssign;
    }

    public long getRouteId() {
        return routeId;
    }

    public Companies getCompany() {
        return company;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public List<CarAssign> getCarAssign() {
        return carAssign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Routes routes = (Routes) o;

        if (routeId != routes.routeId) return false;
        if (company != routes.company) return false;
        if (routeNumber != null ? !routeNumber.equals(routes.routeNumber) : routes.routeNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (routeId ^ (routeId >>> 32));
        result = 31 * result + (routeNumber != null ? routeNumber.hashCode() : 0);
        return result;
    }
}
