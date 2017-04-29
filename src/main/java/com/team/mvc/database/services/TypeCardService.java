package com.team.mvc.database.services;

import com.team.mvc.database.entities.TypeCard;
import com.team.mvc.database.repositories.TypeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TypeCardService {

    @Autowired
    TypeCardRepository typeCardRepository;

    public TypeCard getTypeCardbyStatus(String status){
        return typeCardRepository.getTypeCarbyStatus(status);
    }
}
