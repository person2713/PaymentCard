package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "CARD_BALANCE")
public class CardBalance {

    @Id
    @Column(name = "BALANCE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_BALANCE_SEQ")
    @SequenceGenerator(name = "CARD_BALANCE_SEQ", sequenceName = "CARD_BALANCE_SEQ")
    private Long balanceId;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "CARD_ID")
    @JsonIgnore
    private Cards card;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "BALANCE_ID")
    public Set<BalanceHist> balanceHists = new HashSet<>();

    public CardBalance() {
    }

    public Long getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(Long balanceId) {
        this.balanceId = balanceId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Cards getCard() {
        return card;
    }

    public void setCard(Cards card) {
        this.card = card;
    }

    public Set<BalanceHist> getBalanceHists() {
        return balanceHists;
    }

    public void setBalanceHists(Set<BalanceHist> balanceHists) {
        this.balanceHists = balanceHists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CardBalance that = (CardBalance) o;

        if (balanceId != null ? !balanceId.equals(that.balanceId) : that.balanceId != null) return false;
        if (balance != null ? !balance.equals(that.balance) : that.balance != null) return false;
        return (card != null ? card.equals(that.card) : that.card == null) && (balanceHists != null ? balanceHists.equals(that.balanceHists) : that.balanceHists == null);
    }

    @Override
    public int hashCode() {
        int result = balanceId != null ? balanceId.hashCode() : 0;
        result = 31 * result + (balance != null ? balance.hashCode() : 0);
        result = 31 * result + (card != null ? card.hashCode() : 0);
        result = 31 * result + (balanceHists != null ? balanceHists.hashCode() : 0);
        return result;
    }
}
