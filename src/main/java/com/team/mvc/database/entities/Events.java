package com.team.mvc.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
public class Events {
    private long eventId;
    private String coordinates;
    private long cardId;
    private String secretKey;
    private Timestamp paymentTime;
    private long busId;

    @Id
    @Column(name = "EVENT_ID", nullable = false, precision = 0)
    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "COORDINATES", nullable = false, length = 100)
    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
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
    @Column(name = "SECRET_KEY", nullable = false, length = 100)
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Basic
    @Column(name = "PAYMENT_TIME", nullable = true)
    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Basic
    @Column(name = "BUS_ID", nullable = false, precision = 0)
    public long getBusId() {
        return busId;
    }

    public void setBusId(long busId) {
        this.busId = busId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Events events = (Events) o;

        if (eventId != events.eventId) return false;
        if (cardId != events.cardId) return false;
        if (busId != events.busId) return false;
        if (coordinates != null ? !coordinates.equals(events.coordinates) : events.coordinates != null) return false;
        if (secretKey != null ? !secretKey.equals(events.secretKey) : events.secretKey != null) return false;
        if (paymentTime != null ? !paymentTime.equals(events.paymentTime) : events.paymentTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (eventId ^ (eventId >>> 32));
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 31 * result + (int) (cardId ^ (cardId >>> 32));
        result = 31 * result + (secretKey != null ? secretKey.hashCode() : 0);
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        result = 31 * result + (int) (busId ^ (busId >>> 32));
        return result;
    }
}
