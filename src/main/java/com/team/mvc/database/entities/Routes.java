package com.team.mvc.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
public class Routes {
    private long routeId;
    private long companyId;
    private String routeNumber;

    @Id
    @Column(name = "ROUTE_ID", nullable = false, precision = 0)
    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "COMPANY_ID", nullable = false, precision = 0)
    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "ROUTE_NUMBER", nullable = false, length = 10)
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
        if (companyId != routes.companyId) return false;
        if (routeNumber != null ? !routeNumber.equals(routes.routeNumber) : routes.routeNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (routeId ^ (routeId >>> 32));
        result = 31 * result + (int) (companyId ^ (companyId >>> 32));
        result = 31 * result + (routeNumber != null ? routeNumber.hashCode() : 0);
        return result;
    }
}
