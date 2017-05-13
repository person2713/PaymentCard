package com.team.mvc.database.services;

import com.team.mvc.database.entities.TypeCard;
import com.team.mvc.database.repositories.TypeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TypeCardService {

    @Autowired
    TypeCardRepository typeCardRepository;

    public TypeCard getTypeCardbyStatus(String status){
        return typeCardRepository.getTypeCarbyStatus(status);
    }

    public TypeCard getTypeCardByStatusAndType(String status,String cardType){
        return typeCardRepository.getTypeCardByStatusAndType(status,cardType);
    }

    public List<TypeCard> getAll(){
        return typeCardRepository.getAll();
    }

    public List<String> stringTypeCardStatus(){
        List<String> list = new ArrayList<>();
        for (TypeCard typeCard: typeCardRepository.getAll()) {
            list.add(typeCard.getStatus());
        }
        return list;
    }
//
//    public TypeCard findTypeCardByStatus(String status){
//        return typeCardRepository.getTypeCarbyStatus(status);
//    }
}
