package com.team.mvc.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by vit on 16.03.2017.
 */
@Entity
@Table(name = "EVENTS", schema = "CAPTAIN", catalog = "")
public class EventsEntity {
    private long eventId;
    private String coordinates;
    private String secretKey;
    private Time paymentTime;
    private short busId;

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
    @Column(name = "SECRET_KEY", nullable = false, length = 100)
    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Basic
    @Column(name = "PAYMENT_TIME", nullable = true)
    public Time getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Time paymentTime) {
        this.paymentTime = paymentTime;
    }

    @Basic
    @Column(name = "BUS_ID", nullable = false, precision = 0)
    public short getBusId() {
        return busId;
    }

    public void setBusId(short busId) {
        this.busId = busId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventsEntity that = (EventsEntity) o;

        if (eventId != that.eventId) return false;
        if (busId != that.busId) return false;
        if (coordinates != null ? !coordinates.equals(that.coordinates) : that.coordinates != null) return false;
        if (secretKey != null ? !secretKey.equals(that.secretKey) : that.secretKey != null) return false;
        if (paymentTime != null ? !paymentTime.equals(that.paymentTime) : that.paymentTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (eventId ^ (eventId >>> 32));
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 31 * result + (secretKey != null ? secretKey.hashCode() : 0);
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        result = 31 * result + (int) busId;
        return result;
    }
}
