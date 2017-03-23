package com.team.mvc.database.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by vit on 23.03.2017.
 */
@Entity
public class Cards {
    private long cardId;
    private Long personId;
    private long cardKey;
    private long typeId;

    @Id
    @Column(name = "CARD_ID", nullable = false, precision = 0)
    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "PERSON_ID", nullable = true, precision = 0)
    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    @Basic
    @Column(name = "CARD_KEY", nullable = false, precision = 0)
    public long getCardKey() {
        return cardKey;
    }

    public void setCardKey(long cardKey) {
        this.cardKey = cardKey;
    }

    @Basic
    @Column(name = "TYPE_ID", nullable = false, precision = 0)
    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cards cards = (Cards) o;

        if (cardId != cards.cardId) return false;
        if (cardKey != cards.cardKey) return false;
        if (typeId != cards.typeId) return false;
        if (personId != null ? !personId.equals(cards.personId) : cards.personId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cardId ^ (cardId >>> 32));
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (int) (cardKey ^ (cardKey >>> 32));
        result = 31 * result + (int) (typeId ^ (typeId >>> 32));
        return result;
    }
}
