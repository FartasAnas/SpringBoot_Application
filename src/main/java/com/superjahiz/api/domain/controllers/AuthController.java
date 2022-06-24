package com.superjahiz.api.domain.controllers;

import com.superjahiz.api.domain.entities.AppUser;
import com.superjahiz.api.domain.entities.AuthRequest;
import com.superjahiz.api.domain.entities.Role;
import com.superjahiz.api.domain.repositories.AppUserRepository;
import com.superjahiz.api.domain.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.security.RolesAllowed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AppUserRepository appUserRepository;
    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        AppUser user=appUserRepository.findByUsername(authRequest.getUsername());
        Role role= (Role) user.getRoles().toArray()[0];
        List<SimpleGrantedAuthority>authorities=new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.getName()));
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername()
                            , authRequest.getPassword()
                            , authorities));
        }catch (Exception e){
            return "Invalid username or password";
        }

        return jwtUtil.generateToken(role.getName(),authRequest.getUsername());
    }
}
