package com.team.mvc.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
public class Cities {
    private long cityId;
    private String cityName;

    @Id
    @Column(name = "CITY_ID", nullable = false, precision = 0)
    public long getCityId() {
        return cityId;
    }

    public void setCityId(long cityId) {
        this.cityId = cityId;
    }

    @Basic
    @Column(name = "CITY_NAME", nullable = false, length = 100)
    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cities cities = (Cities) o;

        if (cityId != cities.cityId) return false;
        if (cityName != null ? !cityName.equals(cities.cityName) : cities.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cityId ^ (cityId >>> 32));
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }
}
