package com.team.mvc.converter;

import com.team.mvc.database.entities.TypeCard;
import com.team.mvc.database.services.TypeCardService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class TypeCardConverter implements Converter<Object, TypeCard> {
    @Autowired
    TypeCardService typeCardService;

    public TypeCard convert(Object element) {
        Long id = Long.parseLong((String) element);
        TypeCard typeCard = null;
        try {
            typeCard = typeCardService.getById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return typeCard;
    }
}
