package com.team.mvc.converter;

import com.team.mvc.database.entities.Rollers;
import com.team.mvc.database.services.RoleService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter implements Converter<Object, Rollers> {

    @Autowired
    RoleService roleService;

    public Rollers convert(Object element) {
        Long id = Long.parseLong((String) element);
        Rollers role = null;
        try {
            role = roleService.findById(id);
        } catch (NotFoundException e) {
            e.printStackTrace();
        }

        return role;
    }
}
