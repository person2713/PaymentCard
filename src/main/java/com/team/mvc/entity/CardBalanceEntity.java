package com.team.mvc.entity;

import javax.persistence.*;

/**
 * Created by vit on 16.03.2017.
 */
@Entity
@Table(name = "CARD_BALANCE", schema = "CAPTAIN", catalog = "")
public class CardBalanceEntity {
    private long balanceId;
    private long balance;

    @Id
    @Column(name = "BALANCE_ID", nullable = false, precision = 0)
    public long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(long balanceId) {
        this.balanceId = balanceId;
    }

    @Basic
    @Column(name = "BALANCE", nullable = false, precision = 0)
    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardBalanceEntity that = (CardBalanceEntity) o;

        if (balanceId != that.balanceId) return false;
        if (balance != that.balance) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (balanceId ^ (balanceId >>> 32));
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        return result;
    }
}
