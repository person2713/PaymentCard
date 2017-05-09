package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "CARDS")
public class Cards implements Serializable {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARDS_SEQ")
    @SequenceGenerator(name = "CARDS_SEQ", sequenceName = "CARDS_SEQ")
    private Long cardId;

    @Column(name = "CARD_NAME", length = 30, unique = true)
    private String cardName;


    @Column(name="PERSON_ID")
    private Long personId;

    @Column(name = "CARD_KEY", nullable = false)
    private long cardKey;

    @OneToOne
    @JoinColumn(name="TYPE_ID", nullable = false)
    private TypeCard typeCard;

    @OneToOne(mappedBy = "card")
    private CardBalance cardBalance;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="CARD_ID")
    public Set<BalanceHist> balanceHists = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="CARD_ID")
    public Set<Events> events = new HashSet<>();



    public Cards() {
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public long getCardKey() {
        return cardKey;
    }

    public void setCardKey(long cardKey) {
        this.cardKey = cardKey;
    }

    public TypeCard getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }

    public CardBalance getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(CardBalance cardBalance) {
        this.cardBalance = cardBalance;
    }

    public Set<BalanceHist> getBalanceHists() {
        return balanceHists;
    }

    public void setBalanceHists(Set<BalanceHist> balanceHists) {
        this.balanceHists = balanceHists;
    }

    public Set<Events> getEvents() {
        return events;
    }

    public void setEvents(Set<Events> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cards cards = (Cards) o;

        if (cardKey != cards.cardKey) return false;
        if (cardId != null ? !cardId.equals(cards.cardId) : cards.cardId != null) return false;
        if (cardName != null ? !cardName.equals(cards.cardName) : cards.cardName != null) return false;
        if (personId != null ? !personId.equals(cards.personId) : cards.personId != null) return false;
        if (typeCard != null ? !typeCard.equals(cards.typeCard) : cards.typeCard != null) return false;
        if (cardBalance != null ? !cardBalance.equals(cards.cardBalance) : cards.cardBalance != null) return false;
        if (balanceHists != null ? !balanceHists.equals(cards.balanceHists) : cards.balanceHists != null) return false;
        return events != null ? events.equals(cards.events) : cards.events == null;
    }

    @Override
    public int hashCode() {
        int result = cardId != null ? cardId.hashCode() : 0;
        result = 31 * result + (cardName != null ? cardName.hashCode() : 0);
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (int) (cardKey ^ (cardKey >>> 32));
        result = 31 * result + (typeCard != null ? typeCard.hashCode() : 0);
        result = 31 * result + (cardBalance != null ? cardBalance.hashCode() : 0);
        result = 31 * result + (balanceHists != null ? balanceHists.hashCode() : 0);
        result = 31 * result + (events != null ? events.hashCode() : 0);
        return result;
    }
}
