package com.team.mvc.database.entities;

import javax.persistence.*;


@Entity
@Table(name = "TYPE_CARD")
public class TypeCard {


    @Id
    @Column(name = "TYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYPE_CARD_SEQ")
    @SequenceGenerator(name = "TYPE_CARD_SEQ", sequenceName = "TYPE_CARD_SEQ")
    private long typeId;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    @Column(name = "CARD_TYPE", nullable = false, length = 20)
    private String cardType;


    public TypeCard() {
    }

    public long getTypeId() {
        return typeId;
    }

    public String getStatus() {
        return status;
    }

    public String getCardType() {
        return cardType;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeCard typeCard = (TypeCard) o;

        if (typeId != typeCard.typeId) return false;
        if (status != null ? !status.equals(typeCard.status) : typeCard.status != null) return false;
        if (cardType != null ? !cardType.equals(typeCard.cardType) : typeCard.cardType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (typeId ^ (typeId >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        return result;
    }
}
