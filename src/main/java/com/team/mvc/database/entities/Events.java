package com.team.mvc.database.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;


@Entity
@Table(name = "EVENTS")
public class Events {

    @Id
    @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EVENTS_SEQ")
    @SequenceGenerator(name = "EVENTS_SEQ", sequenceName = "EVENTS_SEQ")
    private long eventId;


    @ManyToOne
    @JoinColumn(name = "CARD_ID")
    private Cards card;


    @Column(name = "LATITUDE", nullable = false)
    private double latitude;

    @Column(name = "LONGITUDE", nullable = false)
    private double longitude;


    @Column(name = "PAYMENT_TIME", nullable = true)
    private Timestamp paymentTime=new Timestamp(Calendar.getInstance().getTime().getTime());


    @ManyToOne
    @JoinColumn(name = "BUS_ID")
    private Buses bus;

    public Events() {
    }

    public long getEventId() {
        return eventId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Cards getCard() {
        return card;
    }


    public Timestamp getPaymentTime() {
        return new Timestamp(paymentTime.getTime());
    }

    public Buses getBus() {
        return bus;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public void setBus(Buses bus) {
        this.bus = bus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Events events = (Events) o;

        if (eventId != events.eventId) return false;
        if (card != events.card) return false;
        if (bus != events.bus) return false;
        if (latitude != events.latitude) return false;
        if (longitude != events.longitude) return false;
        if (paymentTime != null ? !paymentTime.equals(events.paymentTime) : events.paymentTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (eventId ^ (eventId >>> 32));
        result = 31 * result + (int) latitude;
        result = 31 * result + (int) longitude;
        result = 31 * result + (paymentTime != null ? paymentTime.hashCode() : 0);
        return result;
    }
}
