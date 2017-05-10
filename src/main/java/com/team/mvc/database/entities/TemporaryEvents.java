package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Objects;

/**

 */
@Entity
@Table(name = "TEMPORARY_EVENTS")
public class TemporaryEvents  implements Serializable {

    @Id
    @Column(name = "TEMPORARY_EVENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEMPORARY_EVENTS_SEQ")
    @SequenceGenerator(name = "TEMPORARY_EVENTS_SEQ", sequenceName = "TEMPORARY_EVENTS_SEQ")
    private long temporaryEventId;

    @ManyToOne
    @JoinColumn(name = "CARD_ID")
    @JsonBackReference
    private Cards card;

    @Column(name = "LATITUDE", nullable = false)
    @JsonIgnore
    private double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    @JsonIgnore
    private double longitude;


    @Column(name = "PAYMENT_TIME", nullable = true)
    @JsonIgnore
    private Timestamp paymentTime=new Timestamp(Calendar.getInstance().getTime().getTime());


    @ManyToOne
    @JoinColumn(name = "BUS_ID")
    @JsonBackReference
    private Buses bus;

    public TemporaryEvents() {
    }

    public long getTemporaryEventId() {
        return temporaryEventId;
    }

    public void setTemporaryEventId(long temporaryEventId) {
        this.temporaryEventId = temporaryEventId;
    }

    public Cards getCard() {
        return card;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLongitude(long longitude) {
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
        return temporaryEventId == that.temporaryEventId &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(card, that.card) &&
                Objects.equals(paymentTime, that.paymentTime) &&
                Objects.equals(bus, that.bus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temporaryEventId, card, latitude, longitude, paymentTime, bus);
    }
}
