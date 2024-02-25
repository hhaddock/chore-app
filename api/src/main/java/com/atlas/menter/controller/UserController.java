package com.atlas.menter.controller;

import com.atlas.menter.dto.LoginDto;
import com.atlas.menter.dto.UserCreateDto;
import com.atlas.menter.entity.User;
import com.atlas.menter.response.AuthenticateUserReponse;
import com.atlas.menter.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping(value = "/api/user")
    public ResponseEntity<Object> createUser(@RequestBody UserCreateDto user){
        try {
            User u = userService.createUser(user);
            return new ResponseEntity<>(u, HttpStatus.CREATED);
        } catch (RepositoryCreationException ex) {
            return new ResponseEntity<>("Error Creating User", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/api/user")
    public ResponseEntity<Object> deleteUser(@RequestBody Long userId){
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>("User Has been deleted", HttpStatus.OK);
        } catch (RepositoryCreationException ex) {
            return new ResponseEntity<>("Error Deleting User", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/api/signin")
    public ResponseEntity<Object> authenticateUser(@RequestBody LoginDto login){
        String jwtToken = userService.authenticateUser(login);

        if(jwtToken == null) { // could not authenticate user

        }
//        User authenticatedUser = userService.getUserByUsername(login.getUsername());

//        AuthenticateUserReponse response = new AuthenticateUserReponse(
//            authenticatedUser.getUsername(),
//            authenticatedUser.getEmail(),
//            authenticatedUser.getRoles(),
//            authenticatedUser.isEnabled()
//        );

        System.out.println("TOKEN: " + jwtToken);

        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + jwtToken);
        headers.add("Access-Control-Expose-Headers", "Authorization");
        ResponseEntity entity = new ResponseEntity(
                new HashMap<>(),
                headers,
                HttpStatus.OK
        );

        return entity;
    }

}
