package com.asahi.usermanager.user.jwtauth;

import static java.util.Collections.emptyList;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asahi.usermanager.user.dao.AdminRepository;
import com.asahi.usermanager.user.model.Admin;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    AdminRepository repository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin applicationUser = repository.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(applicationUser.getUsername(), applicationUser.getPassword(), (Collection<? extends GrantedAuthority>) emptyList());
    }
}