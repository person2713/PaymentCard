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


    @Column(name = "COMPANY_ID")
    private Long companyId;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owners owners = (Owners) o;

        if (ownerId != null ? !ownerId.equals(owners.ownerId) : owners.ownerId != null) return false;
        if (person != null ? !person.equals(owners.person) : owners.person != null) return false;
        return companyId != null ? companyId.equals(owners.companyId) : owners.companyId == null;
    }

    @Override
    public int hashCode() {
        int result = ownerId != null ? ownerId.hashCode() : 0;
        result = 31 * result + (person != null ? person.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        return result;
    }
}
