package com.dontwait.blog.controllers;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.payloads.request.ApiResponse;
import com.dontwait.blog.payloads.request.UserCreationRequest;
import com.dontwait.blog.payloads.request.UserUpdateRequest;
import com.dontwait.blog.services.UserService;
import jakarta.validation.Valid;
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
    User getUserById(@PathVariable Integer userId) throws Exception {
        return userService.getUserById(userId);
    }
    @GetMapping
    List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping()
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> apiResponse = new ApiResponse();

        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @PutMapping("{userId}")
    User updateUser(@PathVariable Integer userId, @RequestBody UserUpdateRequest request) throws Exception {
        User user = userService.getUserById(userId);
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setAbout(request.getAbout());
        return userService.updateUser(userId, request);
    }

    @DeleteMapping("{userId}")
    String deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
        return "User successfully deleted";
    }

}
