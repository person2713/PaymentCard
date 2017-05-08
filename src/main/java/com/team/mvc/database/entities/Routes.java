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

    @Column(name="ROUTE_PRICE", nullable = false)
    private BigDecimal routePrice;

    @Column(name="COMPANY_ID")
    private Long companyId;

    @Column(name = "ROUTE_NUMBER", nullable = false, length = 10)
    private String routeNumber;

    public Routes() {
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public BigDecimal getRoutePrice() {
        return routePrice;
    }

    public void setRoutePrice(BigDecimal routePrice) {
        this.routePrice = routePrice;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Routes routes = (Routes) o;

        if (routeId != routes.routeId) return false;
        if (routePrice != null ? !routePrice.equals(routes.routePrice) : routes.routePrice != null) return false;
        if (companyId != null ? !companyId.equals(routes.companyId) : routes.companyId != null) return false;
        return routeNumber != null ? routeNumber.equals(routes.routeNumber) : routes.routeNumber == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (routeId ^ (routeId >>> 32));
        result = 31 * result + (routePrice != null ? routePrice.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (routeNumber != null ? routeNumber.hashCode() : 0);
        return result;
    }
}
