package com.dontwait.blog.services.impl;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.payloads.UserDto;
import com.dontwait.blog.repositories.UserRepositoty;
import com.dontwait.blog.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepositoty userRepositoty;

    @Override
    public UserDto createUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, Integer userId) {
        return null;
    }

    @Override
    public UserDto getUserById(Integer id) {
        return null;
    }

    @Override
    public List<UserDto> getUsers() {
        return List.of();
    }

    @Override
    public void deleteUser(Integer userId) {

    }
    private User dtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        return user;
    }

    public UserDto UserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;
    }

}
