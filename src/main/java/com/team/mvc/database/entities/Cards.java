package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "CARDS")
public class Cards implements Serializable {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARDS_SEQ")
    @SequenceGenerator(name = "CARDS_SEQ", sequenceName = "CARDS_SEQ")
    private long cardId;

    @Column(name = "CARD_NAME", length = 30, unique = true)
    private String cardName;


    @Column(name="PERSON_ID")
    private Long personId;

    @Column(name = "CARD_KEY", nullable = false)
    private long cardKey;

    @OneToOne
    @JoinColumn(name="TYPE_ID", nullable = false)
    private TypeCard typeCard;

    public CardBalance getCardBalance() {
        return cardBalance;

    }

    @OneToOne
    @JoinColumn(name="CARD_ID", nullable = false)
    private CardBalance cardBalance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    public List<BalanceHist> balanceHists = new ArrayList<BalanceHist>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card", cascade = CascadeType.REMOVE)
    @JsonManagedReference
    public List<Events> events = new ArrayList<Events>();


    public Cards() {
    }

    public long getCardId() {
        return cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public Long getPersonId() {
        return personId;
    }

    public long getCardKey() {
        return cardKey;
    }

    public TypeCard getTypeCard() {
        return typeCard;
    }

    public List<BalanceHist> getBalanceHists() {
        return balanceHists;
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public void setCardKey(long cardKey) {
        this.cardKey = cardKey;
    }

    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }

    public void setCardBalance(CardBalance cardBalance) {
        this.cardBalance = cardBalance;
    }

    public void setBalanceHists(List<BalanceHist> balanceHists) {
        this.balanceHists = balanceHists;
    }

    public void setEvents(List<Events> events) {
        this.events = events;
    }
}
