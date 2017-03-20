package com.team.mvc.dao.interf;

import com.team.mvc.entity.PersonsEntity;

/**
 * Created by vit on 20.03.2017.
 */
public interface personsDao {
    PersonsEntity findById(int personId);


}
