/*
package com.bosonit.ej15.security.security;

import com.bosonit.ej15.security.person.application.PersonService;
import com.bosonit.ej15.security.person.domain.Person;
import com.bosonit.ej15.security.person.infraestructure.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepository
                .findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("El usuario con username "+username+" no existe"));
        return new UserDetailsImpl(person);
    }
}


 */
