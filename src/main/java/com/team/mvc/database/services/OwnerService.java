package com.team.mvc.database.services;

import com.team.mvc.database.entities.Owners;
import com.team.mvc.database.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OwnerService {
    @Autowired
    OwnerRepository ownerRepository;

    public void saveOwner(Owners owner) {
        ownerRepository.save(owner);
    }
}
