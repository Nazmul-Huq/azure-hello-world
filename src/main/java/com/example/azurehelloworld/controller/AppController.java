package com.example.azurehelloworld.controller;

import com.example.azurehelloworld.dto.CourseDto;
import com.example.azurehelloworld.dto.UserDto;
import com.example.azurehelloworld.model.User;
import com.example.azurehelloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {

    @Autowired UserService userService;

    @PostMapping("/add-user")
    public ResponseEntity<?> addUser(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok().body("user added successfully");
    }

    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody User user){
        userService.save(user);
        return ResponseEntity.ok().body("user updated successfully");
    }


    @GetMapping("/see-all-user")
    public ResponseEntity<List<UserDto>> seeAllUser(){
        List<UserDto> userDtoList = new ArrayList<>();
        List<User> users = (List<User>) userService.findAll();
        users.forEach((user) -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            CourseDto courseDto = new CourseDto();
            courseDto.setId(user.getCourse().getId());
            courseDto.setName(user.getCourse().getName());
            userDto.setCourseDto(courseDto);
            userDtoList.add(userDto);
        });
        return new ResponseEntity<>(userDtoList, HttpStatus.OK);
    }

    @GetMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        userService.deleteUserUsingId(id);
        return ResponseEntity.ok().body("user deleted successfully");
    }




}
