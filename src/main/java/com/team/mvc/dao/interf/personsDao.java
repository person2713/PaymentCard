package com.team.mvc.dao.interf;

import com.team.mvc.entity.Persons;

/**
 * Created by vit on 20.03.2017.
 */
public interface personsDao {
    Persons findById(int personId);
    Persons findById(String SSO_ID);

}
