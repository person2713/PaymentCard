package com.team.mvc.database.entities;

import javax.persistence.*;
import java.math.BigDecimal;



@Entity
@Table(name = "CARD_BALANCE")
public class CardBalance {

    @Id
    @Column(name = "BALANCE_ID")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CARD_BALANCE_SEQ")
    @SequenceGenerator(name = "CARD_BALANCE_SEQ", sequenceName = "CARD_BALANCE_SEQ")
    private long balanceId;

    @OneToOne
    @Column(name = "CARD_ID", nullable = false)
    private Cards card;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    public CardBalance() {}

    public long getBalanceId() {
        return balanceId;
    }

    public Cards getCard() {
        return card;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalanceId(long balanceId) {
        this.balanceId = balanceId;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardBalance that = (CardBalance) o;

        if (balanceId != that.balanceId) return false;
        if (card != that.card) return false;
        if (balance != that.balance) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (balanceId ^ (balanceId >>> 32));
        result = 31 * result + (int) (balance.intValue() ^ (balance.intValue() >>> 32));
        return result;
    }
}
