package com.dontwait.blog.services.impl;

import com.dontwait.blog.entity.User;
import com.dontwait.blog.payloads.request.UserCreationRequest;
import com.dontwait.blog.payloads.request.UserUpdateRequest;
import com.dontwait.blog.repositories.UserRepositoty;
import com.dontwait.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepositoty userRepositoty;

    @Autowired
    public UserServiceImpl(UserRepositoty userRepositoty) {
        this.userRepositoty = userRepositoty;
    }

    @Override
    public User createUser(UserCreationRequest request) {
        User user = new User();

        //If new user creates same name in db -> exception
        if(userRepositoty.existsByName(request.getName()))
            throw new RuntimeException("User name existed.");
        user.setName(request.getName());


        user.setPassword(request.getPassword());

        if(userRepositoty.existsByEmail(request.getEmail()))
            throw new RuntimeException("Email existed.");

        user.setEmail(request.getEmail());
        user.setAbout(request.getAbout());
        return userRepositoty.save(user);
    }

    @Override
    public User updateUser(Integer userId, UserUpdateRequest request) {
        User user = userRepositoty.findById(userId).orElse(null);
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setAbout(request.getAbout());
        return userRepositoty.save(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userRepositoty.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
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
