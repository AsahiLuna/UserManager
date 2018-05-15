package com.asahi.usermanager.user.jwtauth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.asahi.usermanager.user.dao.AdminRepository;
import com.asahi.usermanager.user.model.Admin;
import com.asahi.usermanager.user.model.Role;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    AdminRepository repository;

    public UserDetails loadUserByUsername(String username) {

        Admin admin = repository.findByUsername(username);
        if(admin == null){
            throw new UsernameNotFoundException("管理员不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for(Role role:admin.getRoles())
        {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println(role.getName());
        }
        return new org.springframework.security.core.userdetails.User(admin.getUsername(),
                admin.getPassword(), authorities);
    }
}
