package com.dontwait.blog.services;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    UserDto updateUser(UserDto user, Integer userId);

    UserDto getUserById(Integer id);

    List<UserDto> getUsers();

    void deleteUser(Integer userId);

}
