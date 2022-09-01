package com.example.azurehelloworld.controller;

import com.example.azurehelloworld.model.User;
import com.example.azurehelloworld.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    UserRepo userRepo;

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        userRepo.save(user);
        return ResponseEntity.ok().body("user added successfully");
    }

    @PostMapping("/see-all-user")
    public ResponseEntity<?> seeAllUser(){
        return ResponseEntity.ok().body(userRepo.findAll());
    }
}
