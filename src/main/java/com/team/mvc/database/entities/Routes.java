package com.team.mvc.database.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "ROUTES")
public class Routes implements Serializable {

    @Id
    @Column(name = "ROUTE_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ROUTES_SEQ")
    @SequenceGenerator(name = "ROUTES_SEQ", sequenceName = "ROUTES_SEQ", allocationSize=1)
    private Long routeId;

    @Column(name="ROUTE_PRICE", nullable = false)
    private BigDecimal routePrice;

    @Column(name="COMPANY_ID")
    private Long companyId;

    @Column(name = "ROUTE_NUMBER", nullable = false, length = 10)
    private String routeNumber;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROUTE_ID")
    public Set<CarAssign> carAssigns = new HashSet<>();

    public Routes() {
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
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

    public Set<CarAssign> getCarAssigns() {
        return carAssigns;
    }

    public void setCarAssigns(Set<CarAssign> carAssigns) {
        this.carAssigns = carAssigns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Routes route = (Routes) o;

        if (routeId != null ? !routeId.equals(route.routeId) : route.routeId != null) return false;
        if (routePrice != null ? !routePrice.equals(route.routePrice) : route.routePrice != null) return false;
        if (companyId != null ? !companyId.equals(route.companyId) : route.companyId != null) return false;
        if (routeNumber != null ? !routeNumber.equals(route.routeNumber) : route.routeNumber != null) return false;
        return carAssigns != null ? carAssigns.equals(route.carAssigns) : route.carAssigns == null;
    }

    @Override
    public int hashCode() {
        int result = routeId != null ? routeId.hashCode() : 0;
        result = 31 * result + (routePrice != null ? routePrice.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (routeNumber != null ? routeNumber.hashCode() : 0);
        result = 31 * result + (carAssigns != null ? carAssigns.hashCode() : 0);
        return result;
    }
}
