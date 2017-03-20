package com.team.mvc.dao.impl;

import com.team.mvc.dao.interf.AbstractDao;
import com.team.mvc.dao.interf.personsDao;
import com.team.mvc.entity.PersonsEntity;

/**
 * Created by vit on 20.03.2017.
 */
public class personsDaoImpl extends AbstractDao<Integer, PersonsEntity> implements personsDao {
    @Override
    public PersonsEntity findById(int personId) {
        return null;
    }

    @Override
    public PersonsEntity findById(String SSO_ID) {
        return null;
    }
}
