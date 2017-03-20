package com.team.mvc.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by vit on 16.03.2017.
 */
@Entity
@Table(name = "BALANCE_HIST", schema = "CAPTAIN", catalog = "")
public class BalanceHist {
    private long balanceHistId;
    private long changes;
    private Time dateEvent;

    @Id
    @Column(name = "BALANCE_HIST_ID", nullable = false, precision = 0)
    public long getBalanceHistId() {
        return balanceHistId;
    }

    public void setBalanceHistId(long balanceHistId) {
        this.balanceHistId = balanceHistId;
    }

    @Basic
    @Column(name = "CHANGES", nullable = false, precision = 0)
    public long getChanges() {
        return changes;
    }

    public void setChanges(long changes) {
        this.changes = changes;
    }

    @Basic
    @Column(name = "DATE_EVENT", nullable = true)
    public Time getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Time dateEvent) {
        this.dateEvent = dateEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalanceHist that = (BalanceHist) o;

        if (balanceHistId != that.balanceHistId) return false;
        if (changes != that.changes) return false;
        if (dateEvent != null ? !dateEvent.equals(that.dateEvent) : that.dateEvent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (balanceHistId ^ (balanceHistId >>> 32));
        result = 31 * result + (int) (changes ^ (changes >>> 32));
        result = 31 * result + (dateEvent != null ? dateEvent.hashCode() : 0);
        return result;
    }
}
