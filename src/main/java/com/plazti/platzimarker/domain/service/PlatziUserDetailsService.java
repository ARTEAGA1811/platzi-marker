package com.plazti.platzimarker.domain.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Implementacion de UserDetailsService
@Service
public class PlatziUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Mandamos el usuario, clave y el rol. En este caso el rol es vacio porque no se usa
        //Usamos el noop password encoder, que no encripta nada
        return new User("david", "{noop}arteagaSpring", new ArrayList<>());
    }
}
