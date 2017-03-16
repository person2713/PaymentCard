package com.team.mvc.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by vit on 16.03.2017.
 */
@Entity
@Table(name = "CAR_ASSIGN", schema = "CAPTAIN", catalog = "")
public class CarAssignEntity {
    private int assignId;
    private Time dateAssign;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarAssignEntity that = (CarAssignEntity) o;

        if (assignId != that.assignId) return false;
        if (dateAssign != null ? !dateAssign.equals(that.dateAssign) : that.dateAssign != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assignId;
        result = 31 * result + (dateAssign != null ? dateAssign.hashCode() : 0);
        return result;
    }
}
