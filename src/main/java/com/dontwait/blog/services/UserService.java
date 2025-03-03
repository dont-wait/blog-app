package com.dontwait.blog.services;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.payloads.request.UserCreationRequest;
import com.dontwait.blog.payloads.request.UserUpdateRequest;

import java.util.List;

public interface UserService {

    User createUser(UserCreationRequest user);

    User updateUser(Integer userId, UserUpdateRequest request);
    User getUserById(Integer userId) throws Exception;

    List<User> getUsers();

    void deleteUser(Integer userId);

}
