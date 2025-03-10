package com.dontwait.blog.services;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.dto.request.user.UserCreationRequest;
import com.dontwait.blog.dto.request.user.UserUpdateRequest;
import com.dontwait.blog.dto.response.user.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse createUser(UserCreationRequest user);

    UserResponse updateUser(Integer userId, UserUpdateRequest request);
    UserResponse getUserById(Integer userId) throws Exception;

    List<UserResponse> getUsers();

    void deleteUser(Integer userId);

}
