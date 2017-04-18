package com.team.mvc.database.services;


import com.team.mvc.database.entities.Rollers;
import com.team.mvc.database.repositories.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Rollers findById(long id) throws NotFoundException {
        return roleRepository.getById(id);
    }

    public Rollers findByType(String roleType){
        return roleRepository.findByType(roleType);
    }

    public List<Rollers> findAll() {
        return roleRepository.findAll();
    }


    public List<String> stringRollers(){
        List<String> list = new ArrayList<>();
        for (Rollers role: roleRepository.getAll()) {
            list.add(role.getRoleType());
        }
        return list;
    }
}
