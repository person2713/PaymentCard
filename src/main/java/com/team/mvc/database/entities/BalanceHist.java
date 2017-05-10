package com.team.mvc.database.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


@Entity
@Table(name = "BALANCE_HIST")
public class BalanceHist {

    @Id
    @Column(name = "BALANCE_HIST_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "BALANCE_HIST_SEQ")
    @SequenceGenerator(name = "BALANCE_HIST_SEQ", sequenceName = "BALANCE_HIST_SEQ")
    private Long balanceHistId;

    @Column(name="CARD_ID")
    private Long cardId;

    @Column(name="BALANCE_ID")
    private Long balanceId;

    @Column(name = "CHANGES")
    private BigDecimal changes;


    @Column(name = "DATE_EVENT")
    private Timestamp dateEvent;


    public BalanceHist() {
    }

    public Long getBalanceHistId() {
        return balanceHistId;
    }

    public Long getCardId() {
        return cardId;
    }

    public BigDecimal getChanges() {
        return changes;
    }

    public Timestamp getDateEvent() {
        return dateEvent;
    }

    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceHistId(Long balanceHistId) {
        this.balanceHistId = balanceHistId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public void setChanges(BigDecimal changes) {
        this.changes = changes;
    }

    public void setDateEvent(Timestamp dateEvent) {
        this.dateEvent = dateEvent;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalanceHist that = (BalanceHist) o;

        if (balanceHistId != null ? !balanceHistId.equals(that.balanceHistId) : that.balanceHistId != null)
            return false;
        if (cardId != null ? !cardId.equals(that.cardId) : that.cardId != null) return false;
        if (changes != null ? !changes.equals(that.changes) : that.changes != null) return false;
        if (dateEvent != null ? !dateEvent.equals(that.dateEvent) : that.dateEvent != null) return false;
        return balanceId != null ? balanceId.equals(that.balanceId) : that.balanceId == null;
    }

    @Override
    public int hashCode() {
        int result = balanceHistId != null ? balanceHistId.hashCode() : 0;
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (changes != null ? changes.hashCode() : 0);
        result = 31 * result + (dateEvent != null ? dateEvent.hashCode() : 0);
        result = 31 * result + (balanceId != null ? balanceId.hashCode() : 0);
        return result;
    }
}
