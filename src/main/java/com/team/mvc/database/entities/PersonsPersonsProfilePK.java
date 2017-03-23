package com.team.mvc.database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by vit on 23.03.2017.
 */
public class PersonsPersonsProfilePK implements Serializable {
    private long personId;
    private long personProfileId;

    @Column(name = "PERSON_ID", nullable = false, precision = 0)
    @Id
    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    @Column(name = "PERSON_PROFILE_ID", nullable = false, precision = 0)
    @Id
    public long getPersonProfileId() {
        return personProfileId;
    }

    public void setPersonProfileId(long personProfileId) {
        this.personProfileId = personProfileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonsPersonsProfilePK that = (PersonsPersonsProfilePK) o;

        if (personId != that.personId) return false;
        if (personProfileId != that.personProfileId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (personId ^ (personId >>> 32));
        result = 31 * result + (int) (personProfileId ^ (personProfileId >>> 32));
        return result;
    }
}
