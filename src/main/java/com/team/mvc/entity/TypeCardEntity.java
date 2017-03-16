package com.team.mvc.entity;

import javax.persistence.*;

/**
 * Created by vit on 16.03.2017.
 */
@Entity
@Table(name = "TYPE_CARD", schema = "CAPTAIN", catalog = "")
public class TypeCardEntity {
    private long typeId;
    private String status;
    private String cardType;

    @Id
    @Column(name = "TYPE_ID", nullable = false, precision = 0)
    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, length = 20)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CARD_TYPE", nullable = false, length = 20)
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

        TypeCardEntity that = (TypeCardEntity) o;

        if (typeId != that.typeId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (cardType != null ? !cardType.equals(that.cardType) : that.cardType != null) return false;

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
