package com.team.mvc.dao.interf;

import com.team.mvc.entity.TypeCardEntity;

import java.util.List;

/**
 * Created by vit on 20.03.2017.
 */
public interface typeCardDao {
    TypeCardEntity findByTypeCardId(long typeId);
    TypeCardEntity findByStatus(String status);
    TypeCardEntity findByCardType(String cardType);

    void saveType( TypeCardEntity typeCardEntity);

    void deleteTypebyCardType(String cardType);

    List<TypeCardEntity> findAllType();


}
