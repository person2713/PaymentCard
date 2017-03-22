package com.team.mvc.service.interf;

import com.team.mvc.entity.TypeCardEntity;

import java.util.List;

/**
 * Created by vit on 22.03.2017.
 */
public interface typeCardService {
    TypeCardEntity findByTypeCardId(long typeId);
    TypeCardEntity findByStatus(String status);
    TypeCardEntity findByCardType(String cardType);

    void saveType( TypeCardEntity typeCardEntity);

    void deleteTypebyCardType(String cardType);

    List<TypeCardEntity> findAllType();
}
