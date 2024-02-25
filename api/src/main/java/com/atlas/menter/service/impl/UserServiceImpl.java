package com.atlas.menter.service.impl;

import com.atlas.menter.dto.LoginDto;
import com.atlas.menter.dto.UserCreateDto;
import com.atlas.menter.entity.Role;
import com.atlas.menter.entity.User;
import com.atlas.menter.repository.RoleRepository;
import com.atlas.menter.repository.UserRepository;
import com.atlas.menter.response.AuthenticateUserReponse;
import com.atlas.menter.security.TokenManager;
import com.atlas.menter.security.UserDetailsServiceImpl;
import com.atlas.menter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    TokenManager tokenManager;

    @Override
    public String authenticateUser(LoginDto login) {
        try{
            System.out.println("LOGIN DTO" + " USERNAME: " + login.getUsername() + " PASS: " + login.getPassword());

            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    login.getUsername(), login.getPassword()
            ));

            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(auth);

            final UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());
            final String jwtToken = tokenManager.generateJwtToken(userDetails);

            return jwtToken;
        } catch (AuthenticationException ex) {
            System.out.println("ERROR LOADING AUTH: ");
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public User createUser(UserCreateDto user) {
        System.out.println(user.getUsername());

        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setEnabled(true);

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        newUser.setRoles(Collections.singleton(roles));

        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public void updateUser(Long id, User user) {

    }

    @Override
    public void deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent() || !user.isEmpty()){
            userRepository.delete(user.get());
        }
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent() || !user.isEmpty()){
            return null;
        }
        return user.get();
    }

    @Override
    public User getUserByUsername(String username) {
        System.out.println("SEARCHING FOR " + username);

        Optional<User> user = userRepository.findByUsername(username);
        if(!user.isPresent()){
            System.out.println("COULD NOT FIND USER BY USERNAME!!");
            return null;
        }
        System.out.println("FOUND USER: " + user.get().getUsername());
        return user.get();
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
