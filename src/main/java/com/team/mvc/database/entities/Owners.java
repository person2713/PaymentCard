package com.team.mvc.database.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Owners implements Serializable {


    @Id
    @Column(name = "OWNER_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "OWNERS_SEQ")
    @SequenceGenerator(name = "OWNERS_SEQ", sequenceName = "OWNERS_SEQ", allocationSize=1)
    private Long ownerId;

    @OneToOne
    @JoinColumn(name="PERSON_ID")
    private Persons person;

    @OneToOne
    @JoinColumn(name = "COMPANY_ID")
    private Companies company;

    public Owners() {
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Persons getPerson() {
        return person;
    }

    public void setPerson(Persons person) {
        this.person = person;
    }

    public Companies getCompany() {
        return company;
    }

    public void setCompany(Companies company) {
        this.company = company;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owners owners = (Owners) o;

        if (ownerId != null ? !ownerId.equals(owners.ownerId) : owners.ownerId != null) return false;
        if (person != null ? !person.equals(owners.person) : owners.person != null) return false;
        return company != null ? company.equals(owners.company) : owners.company == null;
    }

    @Override
    public int hashCode() {
        int result = ownerId != null ? ownerId.hashCode() : 0;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
