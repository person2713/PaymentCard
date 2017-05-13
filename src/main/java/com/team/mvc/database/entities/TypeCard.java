package com.team.mvc.database.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "TYPE_CARD")
public class TypeCard implements Serializable{


    @Id
    @Column(name = "TYPE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TYPE_CARD_SEQ")
    @SequenceGenerator(name = "TYPE_CARD_SEQ", sequenceName = "TYPE_CARD_SEQ", allocationSize=1)
    private Long typeId;

    @Column(name = "STATUS", nullable = false, length = 20)
    private String status;

    @Column(name = "CARD_TYPE", nullable = false, length = 20)
    private String cardType;


    public TypeCard() {
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeCard typeCard = (TypeCard) o;

        if (typeId != null ? !typeId.equals(typeCard.typeId) : typeCard.typeId != null) return false;
        if (status != null ? !status.equals(typeCard.status) : typeCard.status != null) return false;
        return cardType != null ? cardType.equals(typeCard.cardType) : typeCard.cardType == null;
    }

    @Override
    public int hashCode() {
        int result = typeId != null ? typeId.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
        return result;
    }
}
