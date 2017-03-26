package com.team.mvc.database.entities;

import javax.persistence.*;


@Entity
@Table(name = "ROLLERS")
public class Rollers {

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLLERS_SEQ")
    @SequenceGenerator(name = "ROLLERS_SEQ", sequenceName = "ROLLERS_SEQ")
    private long roleId;

    @Column(name = "ROLE_TYPE", unique = true)
    private String roleType;
//    = PersonRole.USER.getPersonRole();


    public Rollers() {
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rollers rollers = (Rollers) o;

        if (roleId != rollers.roleId) return false;
        if (roleType != null ? !roleType.equals(rollers.roleType) : rollers.roleType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (roleId ^ (roleId >>> 32));
        result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
        return result;
    }
}
