package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "EVENTS")
public class Events {

    @Id
    @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENTS_SEQ")
    @SequenceGenerator(name = "EVENTS_SEQ", sequenceName = "EVENTS_SEQ")
    private Long eventId;


    @Column(name="CARD_ID")
    private Long cardId;


    @Column(name = "LATITUDE", nullable = false)
    @JsonIgnore
    private double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    @JsonIgnore
    private double longitude;


    @Column(name = "PAYMENT_TIME", nullable = true)
    @JsonIgnore
    private Timestamp paymentTime;

    @Column(name="BUS_ID")
    private Long busId;

    public Events() {
    }

    public Long getEventId() {
        return eventId;
    }

    public Long getCardId() {
        return cardId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public Long getBusId() {
        return busId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Events events = (Events) o;

        if (Double.compare(events.latitude, latitude) != 0) return false;
        if (Double.compare(events.longitude, longitude) != 0) return false;
        if (eventId != null ? !eventId.equals(events.eventId) : events.eventId != null) return false;
        if (cardId != null ? !cardId.equals(events.cardId) : events.cardId != null) return false;
        if (paymentTime != null ? !paymentTime.equals(events.paymentTime) : events.paymentTime != null) return false;
        return busId != null ? busId.equals(events.busId) : events.busId == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        result = 31 * result + (busId != null ? busId.hashCode() : 0);
        return result;
    }
}
