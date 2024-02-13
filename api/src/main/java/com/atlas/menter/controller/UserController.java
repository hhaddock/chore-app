package com.atlas.menter.controller;

import com.atlas.menter.dto.LoginDto;
import com.atlas.menter.dto.UserCreateDto;
import com.atlas.menter.entity.User;
import com.atlas.menter.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.RepositoryCreationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
        String token = userService.authenticateUser(login);

        System.out.println("TOKEN: " + token.toString());
        MultiValueMap<String, String> headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        ResponseEntity entity = new ResponseEntity(headers, HttpStatus.OK);

        return entity;
    }

}
