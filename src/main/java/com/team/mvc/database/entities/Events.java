package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.DoubleSummaryStatistics;


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
    private Double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    @JsonIgnore
    private Double longitude;


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

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Events events = (Events) o;

        if (eventId != null ? !eventId.equals(events.eventId) : events.eventId != null) return false;
        if (cardId != null ? !cardId.equals(events.cardId) : events.cardId != null) return false;
        if (latitude != null ? !latitude.equals(events.latitude) : events.latitude != null) return false;
        if (longitude != null ? !longitude.equals(events.longitude) : events.longitude != null) return false;
        if (paymentTime != null ? !paymentTime.equals(events.paymentTime) : events.paymentTime != null) return false;
        return busId != null ? busId.equals(events.busId) : events.busId == null;
    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        result = 31 * result + (busId != null ? busId.hashCode() : 0);
        return result;
    }
}
