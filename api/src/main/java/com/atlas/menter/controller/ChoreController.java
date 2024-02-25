package com.atlas.menter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ChoreController {

    @PostMapping(value = "/api/chore")
    public ResponseEntity<Object> createChore() {

        return new ResponseEntity<>(new HashMap<>(), HttpStatus.CREATED);
    }
}
