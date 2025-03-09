package com.dontwait.blog.services.impl;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.exception.AppException;
import com.dontwait.blog.exception.ErrorCode;
import com.dontwait.blog.mapper.UserMapper;
import com.dontwait.blog.dto.request.user.UserCreationRequest;
import com.dontwait.blog.dto.request.user.UserUpdateRequest;
import com.dontwait.blog.dto.response.user.UserResponse;
import com.dontwait.blog.repositories.UserRepositoty;
import com.dontwait.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoty userRepositoty;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepositoty userRepositoty, UserMapper userMapper) {
        this.userRepositoty = userRepositoty;
        this.userMapper = userMapper;
    }

    @Override
    public UserResponse createUser(UserCreationRequest request) {

        if(userRepositoty.existsByName(request.getName()))
            throw new AppException(ErrorCode.USER_EXISTED); //by pass for GlobalExceptionHandler to handle that error

        if(userRepositoty.existsByEmail(request.getEmail()))
            throw new AppException(ErrorCode.EMAIL_EXISTED);

        User user = userMapper.toUser(request);

        return userMapper.toUserResponse(userRepositoty.save(user));
    }

    @Override
    public UserResponse updateUser(Integer userId, UserUpdateRequest request) {
        User user = userRepositoty.findById(userId).orElseThrow(() -> new AppException(ErrorCode.USERID_NOT_FOUND));

        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(userRepositoty.save(user));
    }

    @Override
    public UserResponse getUserById(Integer id) {
        return userMapper.toUserResponse(userRepositoty.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.USERID_NOT_FOUND)));
    }

    @Override
    public List<User> getUsers() {
        return userRepositoty.findAll();
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepositoty.deleteById(userId);
    }


}
