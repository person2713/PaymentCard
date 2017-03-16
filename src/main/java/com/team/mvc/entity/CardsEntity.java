package com.team.mvc.entity;

import javax.persistence.*;

/**
 * Created by vit on 16.03.2017.
 */
@Entity
@Table(name = "CARDS", schema = "CAPTAIN", catalog = "")
public class CardsEntity {
    private long cardId;
    private long cardKey;

    @Id
    @Column(name = "CARD_ID", nullable = false, precision = 0)
    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "CARD_KEY", nullable = false, precision = 0)
    public long getCardKey() {
        return cardKey;
    }

    public void setCardKey(long cardKey) {
        this.cardKey = cardKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardsEntity that = (CardsEntity) o;

        if (cardId != that.cardId) return false;
        if (cardKey != that.cardKey) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cardId ^ (cardId >>> 32));
        result = 31 * result + (int) (cardKey ^ (cardKey >>> 32));
        return result;
    }
}
