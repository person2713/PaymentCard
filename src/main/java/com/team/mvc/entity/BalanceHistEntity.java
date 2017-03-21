package com.team.mvc.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by vit on 21.03.2017.
 */
@Entity
@Table(name = "BALANCE_HIST", schema = "CAPTAIN", catalog = "")
public class BalanceHistEntity {
    private long balanceHistId;
    private long cardId;
    private long changes;
    private Time dateEvent;
    private long balanceId;

    @Id
    @Column(name = "BALANCE_HIST_ID", nullable = false, precision = 0)
    public long getBalanceHistId() {
        return balanceHistId;
    }

    public void setBalanceHistId(long balanceHistId) {
        this.balanceHistId = balanceHistId;
    }

    @Basic
    @Column(name = "CARD_ID", nullable = false, precision = 0)
    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
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

    @Basic
    @Column(name = "BALANCE_ID", nullable = false, precision = 0)
    public long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(long balanceId) {
        this.balanceId = balanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalanceHistEntity that = (BalanceHistEntity) o;

        if (balanceHistId != that.balanceHistId) return false;
        if (cardId != that.cardId) return false;
        if (changes != that.changes) return false;
        if (balanceId != that.balanceId) return false;
        if (dateEvent != null ? !dateEvent.equals(that.dateEvent) : that.dateEvent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (balanceHistId ^ (balanceHistId >>> 32));
        result = 31 * result + (int) (cardId ^ (cardId >>> 32));
        result = 31 * result + (int) (changes ^ (changes >>> 32));
        result = 31 * result + (dateEvent != null ? dateEvent.hashCode() : 0);
        result = 31 * result + (int) (balanceId ^ (balanceId >>> 32));
        return result;
    }
}
