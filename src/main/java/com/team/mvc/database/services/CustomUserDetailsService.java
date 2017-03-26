package com.team.mvc.database.services;


import java.util.ArrayList;
import java.util.List;

import com.team.mvc.database.entities.Persons;
import com.team.mvc.database.entities.Rollers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customUserDetailsService")

public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private PersonService personService;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nickname)
            throws UsernameNotFoundException {
        Persons person = personService.findByNickname(nickname);
        System.out.println("User : " + person);
        if (person == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(person.getNickname(), person.getPassword(),
                true, true, true, true, getGrantedAuthorities(person));
    }


    private List<GrantedAuthority> getGrantedAuthorities(Persons person) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        Rollers userRole = person.getRole();
        System.out.println("UserRole : " + userRole);
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userRole.getRoleType()));
        System.out.print("authorities :" + authorities);
        return authorities;
    }
}
