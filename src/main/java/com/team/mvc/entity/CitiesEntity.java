package com.team.mvc.entity;

import javax.persistence.*;

/**
 * Created by vit on 16.03.2017.
 */
@Entity
@Table(name = "CITIES", schema = "CAPTAIN", catalog = "")
public class CitiesEntity {
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
    @Column(name = "CITY_NAME", nullable = false, length = 30)
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

        CitiesEntity that = (CitiesEntity) o;

        if (cityId != that.cityId) return false;
        if (cityName != null ? !cityName.equals(that.cityName) : that.cityName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cityId ^ (cityId >>> 32));
        result = 31 * result + (cityName != null ? cityName.hashCode() : 0);
        return result;
    }
}
