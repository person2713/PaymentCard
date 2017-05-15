package com.team.mvc.database.services;

import com.team.mvc.database.entities.Owners;
import com.team.mvc.database.repositories.OwnerRepository;
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

    public void saveOwner(Owners owner) {
        ownerRepository.save(owner);
    }

    public List<Owners> getAll(){
        return ownerRepository.getAll();
    }

    public Owners getById(Long id) throws NotFoundException {return ownerRepository.getById(id);}

    public void update(Owners owners) {
        ownerRepository.update(owners);
    }

    public void delete(Long id){
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
