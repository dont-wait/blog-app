package com.dontwait.blog.controllers;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.dto.request.ApiResponse;
import com.dontwait.blog.dto.request.user.UserCreationRequest;
import com.dontwait.blog.dto.request.user.UserUpdateRequest;
import com.dontwait.blog.dto.response.user.UserResponse;
import com.dontwait.blog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    ApiResponse<UserResponse> getUserById(@PathVariable Integer userId) throws Exception {

        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.getUserById(userId));
        return apiResponse;
    }
    @GetMapping
    List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping()
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {

        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @PutMapping("{userId}")
    ApiResponse<UserResponse> updateUser(@PathVariable Integer userId, @RequestBody UserUpdateRequest request) throws Exception {

        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userService.updateUser(userId, request));

        return apiResponse;
    }

    @DeleteMapping("{userId}")
    ApiResponse<String> deleteUser(@PathVariable Integer userId) {

        ApiResponse<String> apiResponse = new ApiResponse<>();
        userService.deleteUser(userId);
        apiResponse.setResult("User successfully deleted");

        return apiResponse;
    }

}
