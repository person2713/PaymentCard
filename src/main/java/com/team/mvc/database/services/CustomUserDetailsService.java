package com.team.mvc.database.services;

import java.util.ArrayList;
import java.util.List;

import com.team.mvc.database.entities.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin.util.UserProfile;

@Service("customUserDetailsService")

public class CustomUserDetailsService implements UserDetailsService{
    @Autowired
    private PersonService personService;

    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String nickname)
            throws UsernameNotFoundException {
        Persons person = personService.findByNickName(nickname);
        System.out.println("Person : "+person);
        if(person==null){
            System.out.println("Person not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(person.getGetNickname(), person.getPassword(),
                true, true, true, true, getGrantedAuthorities(person));
    }


    private List<GrantedAuthority> getGrantedAuthorities(Persons person){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for(UserProfile userProfile : person.getRolles){
            System.out.println("UserProfile : "+userProfile);
            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }
}
