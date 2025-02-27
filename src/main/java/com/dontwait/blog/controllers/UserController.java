package com.dontwait.blog.controllers;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.payloads.request.UserCreationRequest;
import com.dontwait.blog.payloads.request.UserUpdateRequest;
import com.dontwait.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("{userId}")
    ResponseEntity<User> getUserById(@PathVariable Integer userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping
    ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK) ;
    }

    @PostMapping()
    ResponseEntity<User> createUser(@RequestBody UserCreationRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);
    }

    @PutMapping("{userId}")
    ResponseEntity<User> updateUser(@PathVariable Integer userId, @RequestBody UserUpdateRequest request) {
        User user = userService.getUserById(userId);
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setAbout(request.getAbout());
        return new ResponseEntity<>(userService.updateUser(userId, request), HttpStatus.OK);
    }

    @DeleteMapping("{userId}")
    ResponseEntity<String> deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.OK);
    }

}
