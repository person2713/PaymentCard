package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Objects;

/**

 */
@Entity
@Table(name = "TEMPORARY_EVENTS")
public class TemporaryEvents {

    @Id
    @Column(name = "TEMPORARY_EVENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMPORARY_EVENTS_SEQ")
    @SequenceGenerator(name = "TEMPORARY_EVENTS_SEQ", sequenceName = "TEMPORARY_EVENTS_SEQ")
    private Long temporaryEventId;

    @ManyToOne
    @JoinColumn(name = "CARD_ID")
    @JsonBackReference
    private Cards card;

    @Column(name = "LATITUDE", nullable = false)
    @JsonIgnore
    private Double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    @JsonIgnore
    private Double longitude;


    @Column(name = "PAYMENT_TIME", nullable = true)
    @JsonIgnore
    private Timestamp paymentTime=new Timestamp(Calendar.getInstance().getTime().getTime());


    @ManyToOne
    @JoinColumn(name = "BUS_ID")
    @JsonBackReference
    private Buses bus;

    public TemporaryEvents() {
    }

    public Long getTemporaryEventId() {
        return temporaryEventId;
    }

    public void setTemporaryEventId(Long temporaryEventId) {
        this.temporaryEventId = temporaryEventId;
    }

    public Cards getCard() {
        return card;
    }

    public void setCard(Cards card) {
        this.card = card;
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

    public Buses getBus() {
        return bus;
    }

    public void setBus(Buses bus) {
        this.bus = bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemporaryEvents that = (TemporaryEvents) o;

        if (temporaryEventId != null ? !temporaryEventId.equals(that.temporaryEventId) : that.temporaryEventId != null)
            return false;
        if (card != null ? !card.equals(that.card) : that.card != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        if (paymentTime != null ? !paymentTime.equals(that.paymentTime) : that.paymentTime != null) return false;
        return bus != null ? bus.equals(that.bus) : that.bus == null;
    }

    @Override
    public int hashCode() {
        int result = temporaryEventId != null ? temporaryEventId.hashCode() : 0;
        result = 31 * result + (card != null ? card.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        result = 31 * result + (bus != null ? bus.hashCode() : 0);
        return result;
    }
}
