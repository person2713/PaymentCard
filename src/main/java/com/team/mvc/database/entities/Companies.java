package com.team.mvc.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
public class Companies {
    private long companyId;
    private String companyName;
    private String phoneNumber;
    private Long cityId;

    @Id
    @Column(name = "COMPANY_ID", nullable = false, precision = 0)
    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "COMPANY_NAME", nullable = false, length = 30)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "PHONE_NUMBER", nullable = true, length = 20)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "CITY_ID", nullable = true, precision = 0)
    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Companies companies = (Companies) o;

        if (companyId != companies.companyId) return false;
        if (companyName != null ? !companyName.equals(companies.companyName) : companies.companyName != null)
            return false;
        if (phoneNumber != null ? !phoneNumber.equals(companies.phoneNumber) : companies.phoneNumber != null)
            return false;
        if (cityId != null ? !cityId.equals(companies.cityId) : companies.cityId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (companyId ^ (companyId >>> 32));
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (cityId != null ? cityId.hashCode() : 0);
        return result;
    }
}
