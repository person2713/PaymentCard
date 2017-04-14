package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@Entity
public class Owners {


    @Id
    @Column(name = "OWNER_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "OWNERS_SEQ")
    @SequenceGenerator(name = "OWNERS_SEQ", sequenceName = "OWNERS_SEQ")
    private long ownerId;


    @OneToOne
    @JoinColumn(name="PERSON_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persons person;

    @ManyToOne
    @JoinColumn(name = "COMPANY_ID")
    @JsonBackReference
    private Companies company;



    public void setPerson(Persons person) {
        this.person = person;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    public Persons getPerson() {
        return person;
    }

    public Companies getCompany() {
        return company;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owners owners = (Owners) o;

        if (ownerId != owners.ownerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (ownerId ^ (ownerId >>> 32));
    }
}
