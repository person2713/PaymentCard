package com.team.mvc.database.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "CARDS")
public class Cards {

    @Id
    @Column(name = "CARD_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARDS_SEQ")
    @SequenceGenerator(name = "CARDS_SEQ", sequenceName = "CARDS_SEQ")
    private long cardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Persons person;

    @Column(name = "CARD_KEY", nullable = false)
    private long cardKey;

    @OneToOne
    @JoinColumn(name="TYPE_ID", nullable = false)
    private TypeCard typeCard;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    public List<BalanceHist> balanceHists = new ArrayList<BalanceHist>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "card")
    public List<Events> events = new ArrayList<Events>();



    public long getCardId() {
        return cardId;
    }

    public Persons getPerson() {
        return person;
    }

    public long getCardKey() {
        return cardKey;
    }

    public TypeCard getTypeCard() {
        return typeCard;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }

    public void setCardKey(long cardKey) {
        this.cardKey = cardKey;
    }

    public void setTypeCard(TypeCard typeCard) {
        this.typeCard = typeCard;
    }

    public Cards() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cards cards = (Cards) o;

        if (cardId != cards.cardId) return false;
        if (cardKey != cards.cardKey) return false;
        if (typeCard != cards.typeCard) return false;
        if (person != null ? !person.equals(cards.person) : cards.person != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cardId ^ (cardId >>> 32));
        result = 31 * result + (int) (cardKey ^ (cardKey >>> 32));
        return result;
    }
}
