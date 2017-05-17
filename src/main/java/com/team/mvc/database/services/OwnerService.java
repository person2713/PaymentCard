package com.team.mvc.database.services;

import com.team.mvc.database.entities.Owners;
import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.repositories.OwnerRepository;
import com.team.mvc.database.repositories.PersonRepository;
import com.team.mvc.database.repositories.RoleRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OwnerService {

    @Autowired
    OwnerRepository ownerRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    RoleRepository roleRepository;


    public void saveOwner(Owners owner) {
        owner.getPerson().setRole(roleRepository.findByType("OWNER"));
        personRepository.save(owner.getPerson());
        Long personId = personRepository.findByNickname(owner.getPerson().getNickname()).getPersonId();
        owner.getPerson().setPersonId(personId);
        ownerRepository.save(owner);
    }

    public List<Owners> getAll() {
        return ownerRepository.getAll();
    }

    public Owners getById(Long id) throws NotFoundException {
        return ownerRepository.getById(id);
    }

    public void update(Owners owner) {
        owner.getPerson().setRole(roleRepository.findByType("OWNER"));
        personRepository.update(owner.getPerson());
        ownerRepository.update(owner);
    }

    public void delete(Long id) {
        try {
            ownerRepository.delete(ownerRepository.getById(id));
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean isOwnerNicknameUnique(Long id, String nickname) {
        Owners owner = findByNickname(nickname);
        return (owner == null || ((id != null) && (owner.getOwnerId().equals(id))));
    }

    public Owners findByNickname(String nickname) {
        return ownerRepository.findByNickname(nickname);
    }
}
