package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.personsDao;
import com.team.mvc.entity.Persons;

/**
 * Created by vit on 20.03.2017.
 */
public class personsDaoImpl extends AbstractDao<Integer, Persons> implements personsDao {
    @Override
    public Persons findById(int personId) {
        return null;
    }

    @Override
    public Persons findById(String SSO_ID) {
        return null;
    }
}
