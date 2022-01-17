package com.backend.lmsapi.controllers;

import java.util.List;

import com.backend.lmsapi.model.User;
import com.backend.lmsapi.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/get")
    public ResponseEntity<User> getUser(@RequestParam String username) {
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }
}
