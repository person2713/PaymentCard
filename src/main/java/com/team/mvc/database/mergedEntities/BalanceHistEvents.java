package com.team.mvc.database.mergedEntities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class BalanceHistEvents implements Serializable{
    private String transactionType;
    private BigDecimal balance;
    private Timestamp dateEvent;
    private Long routeId;
    private String routeNumber;
    private Long busId;
    private Long cardId;
    private Double latitude;
    private Double longitude;
    private Long eventId;

    public BalanceHistEvents() {
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Timestamp getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Timestamp dateEvent) {
        this.dateEvent = dateEvent;
    }

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(String routeNumber) {
        this.routeNumber = routeNumber;
    }

    public Long getBusId() {
        return busId;
    }

    public void setBusId(Long busId) {
        this.busId = busId;
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

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BalanceHistEvents)) return false;

        BalanceHistEvents that = (BalanceHistEvents) o;

        if (!transactionType.equals(that.transactionType)) return false;
        if (!balance.equals(that.balance)) return false;
        if (!dateEvent.equals(that.dateEvent)) return false;
        if (routeId != null ? !routeId.equals(that.routeId) : that.routeId != null) return false;
        if (routeNumber != null ? !routeNumber.equals(that.routeNumber) : that.routeNumber != null) return false;
        if (busId != null ? !busId.equals(that.busId) : that.busId != null) return false;
        if (cardId != null ? !cardId.equals(that.cardId) : that.cardId != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longitude != null ? !longitude.equals(that.longitude) : that.longitude != null) return false;
        return eventId != null ? eventId.equals(that.eventId) : that.eventId == null;
    }

    @Override
    public int hashCode() {
        int result = transactionType.hashCode();
        result = 31 * result + balance.hashCode();
        result = 31 * result + dateEvent.hashCode();
        result = 31 * result + (routeId != null ? routeId.hashCode() : 0);
        result = 31 * result + (routeNumber != null ? routeNumber.hashCode() : 0);
        result = 31 * result + (busId != null ? busId.hashCode() : 0);
        result = 31 * result + (cardId != null ? cardId.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (eventId != null ? eventId.hashCode() : 0);
        return result;
    }
}
