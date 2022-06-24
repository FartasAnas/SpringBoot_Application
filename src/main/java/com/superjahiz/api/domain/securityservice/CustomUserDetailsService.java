package com.superjahiz.api.domain.securityservice;

import com.superjahiz.api.domain.entities.AppUser;
import com.superjahiz.api.domain.entities.Role;
import com.superjahiz.api.domain.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user= appUserRepository.findByUsername(username);
        Role role= (Role) user.getRoles().toArray()[0];
        List<SimpleGrantedAuthority> authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
