package com.team.mvc.entity;

import javax.persistence.*;

/**
 * Created by vit on 21.03.2017.
 */
@Entity
@Table(name = "CARDS", schema = "CAPTAIN", catalog = "")
public class CardsEntity {
    private long cardId;
    private Integer personId;
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
    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
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

        CardsEntity that = (CardsEntity) o;

        if (cardId != that.cardId) return false;
        if (cardKey != that.cardKey) return false;
        if (typeId != that.typeId) return false;
        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;

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
