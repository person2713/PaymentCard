package com.team.mvc.database.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ROLLERS")
public class Rollers implements Serializable {

    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLLERS_SEQ")
    @SequenceGenerator(name = "ROLLERS_SEQ", sequenceName = "ROLLERS_SEQ", allocationSize=1)
    private Long roleId;

    @Column(name = "ROLE_TYPE", unique = true)
    private String roleType;

    public Rollers() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
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

        if (roleId != null ? !roleId.equals(rollers.roleId) : rollers.roleId != null) return false;
        return roleType != null ? roleType.equals(rollers.roleType) : rollers.roleType == null;
    }

    @Override
    public int hashCode() {
        int result = roleId != null ? roleId.hashCode() : 0;
        result = 31 * result + (roleType != null ? roleType.hashCode() : 0);
        return result;
    }
}
