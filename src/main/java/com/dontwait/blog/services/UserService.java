package com.dontwait.blog.services;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.payloads.request.UserCreationRequest;
import com.dontwait.blog.payloads.request.UserUpdateRequest;
import com.dontwait.blog.payloads.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserCreationRequest user);

    UserResponse updateUser(Integer userId, UserUpdateRequest request);
    UserResponse getUserById(Integer userId) throws Exception;

    List<User> getUsers();

    void deleteUser(Integer userId);

}
